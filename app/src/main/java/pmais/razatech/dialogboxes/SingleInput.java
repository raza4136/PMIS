package pmais.razatech.dialogboxes;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pmais.razatech.R;


public class SingleInput extends Dialog implements View.OnClickListener {
    private Context ctx;
    private TextView mTitle;
    private EditText mEditText;
    private Button mPostiveButton;
    private Button mNegtiveButton;
    private String[] mTexts;
    private int[] mButtonsVisiability;
    private boolean isCancelable = false;
    private DialogClicksListener mMyListener;

    public SingleInput(Context context, boolean cancelable, int[] buttonVisibility, String[] texts, DialogClicksListener listener) {
        super(context);
        this.ctx = context;
        this.mTexts = texts;
        this.mMyListener = listener;
        this.isCancelable = cancelable;
        this.mButtonsVisiability = buttonVisibility;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.single_input_dialog_box);
        Modification();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.singleInputLayoutOkButton:
                mMyListener.onButtonClick(1, mEditText.getText().toString().trim());
                break;
            case R.id.singleInputLayoutCancelButton:
                mMyListener.onButtonClick(0, mEditText.getText().toString().trim());
                break;

        }
        dismiss();
    }

    private void Modification() {
        setCancelable(isCancelable);
        mTitle = findViewById(R.id.singleInputLayoutTitle);
        mEditText = findViewById(R.id.singleInputLayoutEditText);
        mPostiveButton = findViewById(R.id.singleInputLayoutOkButton);
        mNegtiveButton = findViewById(R.id.singleInputLayoutCancelButton);
        mTitle.setText(mTexts[0]);
        if (!mTexts[1].equals(""))
            mEditText.setHint(mTexts[1]);
        if (!mTexts[2].equals(""))
            mEditText.setText(mTexts[2]);
        mPostiveButton.setText(mTexts[3]);
        mNegtiveButton.setText(mTexts[4]);
        mPostiveButton.setVisibility(mButtonsVisiability[0]);
        mNegtiveButton.setVisibility(mButtonsVisiability[1]);
        mPostiveButton.setOnClickListener(this);
        mNegtiveButton.setOnClickListener(this);

    }

    public void setError(String val) {
        mEditText.setError(val);
    }

    public void setEditTextType() {
        mEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
    }

    public interface DialogClicksListener {
        void onButtonClick(int buttonId, String EditTextValue);
    }

}

//Demo Callings =
//SingleInputAlertBox SIAB = new SingleInputAlertBox(this, (buttonId, EditTextValue) -> {
//    Positive
//    if (buttonId == 1) {
//        Toast.makeText(Activity_Splash.this, "Postive" + EditTextValue, Toast.LENGTH_SHORT).show();
//    } else if (buttonId == 0) {
//        Negative
//        Toast.makeText(Activity_Splash.this, "NEg" + EditTextValue, Toast.LENGTH_SHORT).show();
//    }
//}, new int[]{0, 8}, getResources().getString(R.string.enterHostTitle),
//        getResources().getString(R.string.enterHost), "Submit", "Cancel");
//        SIAB.show();