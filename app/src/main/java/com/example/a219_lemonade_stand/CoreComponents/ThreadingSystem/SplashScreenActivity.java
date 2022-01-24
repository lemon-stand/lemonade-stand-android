package com.example.a219_lemonade_stand.CoreComponents.ThreadingSystem;


/**     Import Libraries   **/
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.example.a219_lemonade_stand.CoreComponents.InitLoader;
import com.example.a219_lemonade_stand.LoginSystem.LoginSystemActivity;
import com.example.a219_lemonade_stand.MenuSystem.MainMenuActivity;
import com.example.a219_lemonade_stand.R;


/**
 *  Splash Screen Activity Class
 *
 *  Loads in any required details and checks for permissions
 *  Allows the user to accept or deny permissions
 *  Shows a loading bar, background and text
 *
 */
public class SplashScreenActivity extends AppCompatActivity {

    //debugging value, true allows skipping straight to the Main Menu.
    boolean bool_skipLoginSystem = true;

        /**
         * OnCreate Function for Any Activity
         * @param savedInstanceState
         */
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash_screen);   //splash screen layout

            //Splash screen thread which will load mainmenu
            Thread thread = new Thread() {

                /**
                 * Function to pre-run function to go through protocols before moving activities
                 */
                @Override
                public void run() {

                    //try function will run through init loader to check for permissions.
                    try {

                        sleep(1500);     //Show the screen for 3 seconds


                        //initiate intent for permissions and loader
                        Intent intent_initLoader = new Intent(SplashScreenActivity.this, InitLoader.class);

                        //SplashScreen activity moves activity to init loader
                        SplashScreenActivity.this.startActivity(intent_initLoader);


                        System.out.println("perms accepted");   //legacy code, to be removed...


                    } catch(Exception e) {

                        e.printStackTrace();     //print error in stack

                    } finally {

                        //Initialize intent to go from the Splash screen to the Login System Activity
                        Intent intent_PostSplash = new Intent(SplashScreenActivity.this, LoginSystemActivity.class);

                        //debugging to skip straight to the main menu
                       /* if(bool_skipLoginSystem = false ) {
                            intent_PostSplash = new Intent(SplashScreenActivity.this, MainMenuActivity.class);
                        }*/

                        //start Post-Splash Activity
                        startActivity(intent_PostSplash);


                    }
                }
            };

            //start thread
            thread.start();


        }

    /**
     * Thread onPause Function
     */
    @Override
    protected void onPause() {
        super.onPause();

        finish(); //finish activity
    }
}