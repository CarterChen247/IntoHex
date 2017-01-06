package me.komis.int2hex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText et_major, et_minor;
    private Button btn_convert, btn_reset;
    private boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_major = (EditText) findViewById(R.id.et_major);
        et_major.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        et_major.setInputType(InputType.TYPE_CLASS_NUMBER);
        et_minor = (EditText) findViewById(R.id.et_minor);
        et_minor.setImeOptions(EditorInfo.IME_ACTION_DONE);
        et_minor.setInputType(InputType.TYPE_CLASS_NUMBER);
        btn_convert = (Button) findViewById(R.id.btn_convert);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isValidInput()){

                    et_major.setText(intoHexString(et_major.getText().toString()));
                    et_minor.setText(intoHexString(et_minor.getText().toString()));
                    btn_convert.setEnabled(false);
                    btn_reset.setEnabled(true);
                }


            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                et_major.setText("");
                et_minor.setText("");
                btn_convert.setEnabled(true);
                btn_reset.setEnabled(false);

            }
        });
        btn_reset.setEnabled(false);
    }

    private boolean isValidInput() {

        if (!et_major.getText().toString().matches("")&&!et_minor.getText().toString().matches("") ){
            return  true;
        }else{
            return false;
        }

    }

    public String intoHexString(String input) {

            return Integer.toHexString(Integer.parseInt(input));
    }
}
