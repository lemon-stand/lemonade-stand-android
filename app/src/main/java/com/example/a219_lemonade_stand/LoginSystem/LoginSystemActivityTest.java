package com.example.a219_lemonade_stand.LoginSystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;
import net.yslibrary.android.keyboardvisibilityevent.util.UIUtil;

import java.util.Timer;
import java.util.TimerTask;


public class LoginSystemActivityTest extends AppCompatActivity {



    //Declaring Views & Variables:





    private Handler handler = new Handler();
    private final static long Interval = 30;



    public static boolean editUsername_bool = true;

    private EditText eUser;
    private EditText ePass;











    private LoginSystemActivityView lsView;

    // private Player lsap = new Player();



    private  void hideKeyboard(EditText _editText) {

        InputMethodManager manager = (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE
        );

        manager.hideSoftInputFromWindow(_editText.getApplicationWindowToken(), 0);

    }

    private void showKeyboard(View view) {

        //InputMethodManger
        InputMethodManager manager = (InputMethodManager) getSystemService(
                Context.INPUT_METHOD_SERVICE
        );
        manager.showSoftInput(view, 0);
        //manager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);



/*        _editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {

                String s = _editText.getText().toString().trim();


                if(actionId == EditorInfo.IME_ACTION_DONE) {

                    hideKeyboard(_editText);
                    return true;

                }

                return false;
            }
        });*/


    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();




        lsView = new LoginSystemActivityView(this);

        // eUser = (lsView.getUserString()).toString();


        editUsername_bool = lsView.returneUser();


        /*if(editUsername_bool = Boolean.parseBoolean(null)) {
            editUsername_bool = true;
        }*/

        eUser = new EditText(this);

        ePass = new EditText(this);

        //set soft mode

        //lsView.setFocusable(false);
        //lsView.setFocusableInTouchMode(false); // user touches widget on phone with touch screen
        //lsView.setClickable(false); // user navigates with wheel and selects widget

        /*getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        showKeyboard(lsView);*/

        //show key
        if(editUsername_bool == true){
            //showKeyboard(editText);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
            //showKeyboard(eUser);

            showKeyboard(lsView);

        }

        if(editUsername_bool == false){
            hideKeyboard(eUser);
        }


        setContentView(lsView);



/*
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        lsView.invalidate();
                    }
                });
            }
        }, 0, Interval);*/







    }

}
