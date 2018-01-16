package com.mocelin.meusconvidados02.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.mocelin.meusconvidados02.R;
import com.mocelin.meusconvidados02.business.GuestBusiness;
import com.mocelin.meusconvidados02.constants.GuestConstants;
import com.mocelin.meusconvidados02.entities.GuestEntity;

public class GuestFormActivity extends AppCompatActivity implements View.OnClickListener {


    private ViewHolder mViewHolder = new ViewHolder();
    private GuestBusiness mGuestBusiness;
    private int mGuestId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_form);

        this.mViewHolder.mEditName = findViewById(R.id.edit_name);
        this.mViewHolder.mRadioNotConfirmed = findViewById(R.id.radio_not_confirmed);
        this.mViewHolder.mRadioPresent = findViewById(R.id.radio_present);
        this.mViewHolder.mRadioAbsent = findViewById(R.id.radio_absent);
        this.mViewHolder.mButtonSave = findViewById(R.id.button_save);

        this.mGuestBusiness = new GuestBusiness(this);

        this.setListeners();

        this.loadDataFromActivity();
    }

    private void loadDataFromActivity() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.mGuestId = bundle.getInt(GuestConstants.BundleConstants.GUEST_ID);
        }

        //carregar convidado do b.d
        GuestEntity guestEntity = this.mGuestBusiness.load(this.mGuestId);

        //preencher valores
        this.mViewHolder.mEditName.setText(guestEntity.getName());
        if (guestEntity.getConfirmed() == GuestConstants.CONFIRMATION.PRESENT) {
            this.mViewHolder.mRadioPresent.setChecked(true);
        } else if (guestEntity.getConfirmed() == GuestConstants.CONFIRMATION.ABSENT) {
            this.mViewHolder.mRadioAbsent.setChecked(true);
        } else {
            this.mViewHolder.mRadioNotConfirmed.setChecked(true);
        }

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_save) {
            this.handleSave();
        }
    }

    private void setListeners() {
        this.mViewHolder.mButtonSave.setOnClickListener(this);
    }


    private void handleSave() {

        if (!this.validateSave()) {
            return;
        }

        GuestEntity guestEntity = new GuestEntity();
        guestEntity.setName(this.mViewHolder.mEditName.getText().toString());

        if (this.mViewHolder.mRadioNotConfirmed.isChecked()) {
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.NOT_CONFIRMED);
        } else if (this.mViewHolder.mRadioPresent.isChecked()) {
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.PRESENT);
        } else {
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.ABSENT);
        }

        //salva entidade convidado
        if (this.mGuestBusiness.insert(guestEntity)) {
            Toast.makeText(this, "Convidado salvo", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Ocorreu um erro", Toast.LENGTH_SHORT).show();
        }

        finish();
    }

    private boolean validateSave() {

        if (this.mViewHolder.mEditName.getText().toString().equals("")) {
            this.mViewHolder.mEditName.setError("o nome");
            return false;
        }
        return true;
    }

    private static class ViewHolder {
        private EditText mEditName;
        private RadioButton mRadioNotConfirmed;
        private RadioButton mRadioPresent;
        private RadioButton mRadioAbsent;
        private Button mButtonSave;
    }
}
