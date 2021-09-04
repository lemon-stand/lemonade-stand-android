package com.example.a219_lemonade_stand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a219_lemonade_stand.databinding.ActivityMarketBinding;

public class SingleplayerActivity extends AppCompatActivity {



    private Button startday;
    private Button buylemonsbutton;

    private ImageView logo;

    private TextView balance;
    private TextView lemonsamount;
    private TextView sugaramount;
    private TextView wateramount;

    private String moneybalance;
    private String lemonbalance;

    private Button finishday;
    //private ImageView logo;
    private ImageView stall;
    private ImageView seller;
    private ImageView buyer;
    //private TextView balance;
    private TextView lemonscount;
    private TextView sugarcount;
    private TextView watercount;


    private static final int MENU_RESUME = 1;
    private static final int MENU_START = 2;
    private static final int MENU_STOP = 3;

    //private GameThread mGameThread;
    //private GameView mGameView;

    //game loop
    public spGame a1 = new spGame();

    private boolean nextdaycheck = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_singleplayer);


        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        //Set up a new game, we don't care about previous states
        //mGameThread = new TheGame(mGameView);
        //mGameView.setThread(mGameThread);
        //mGameThread.setState(GameThread.STATE_READY);
        //mGameView.startSensor((SensorManager)getSystemService(Context.SENSOR_SERVICE));


        if(nextdaycheck == false)
        {



            sugaramount = (TextView) findViewById(R.id.s_sugar);

            sugaramount.setText("Sugar: ");

            wateramount = (TextView) findViewById(R.id.s_water);
            wateramount.setText("Water: ");

            balance = (TextView) findViewById(R.id.s_balance);
            moneybalance = Integer.toString(a1.money);
            setMoneybalance(balance, moneybalance);

            balance = (TextView) findViewById(R.id.s_balance);
            moneybalance = Integer.toString(a1.money);
            balance.setText("$" + moneybalance);

            lemonsamount = (TextView) findViewById(R.id.s_lemons);
            lemonbalance = Integer.toString(a1.lemons);
            lemonsamount.setText("Lemons: " + lemonbalance);

            buylemonsbutton = (Button) findViewById(R.id.bbuylemons);
            buylemonsbutton.setOnClickListener(new View.OnClickListener() {

                /**
                 * Function to return boolean value based on user data.
                 * @param v
                 */
                @Override
                public void onClick(View v) {

                    a1.buyLemons();
                    moneybalance = Integer.toString(a1.money);
                    setMoneybalance(balance, moneybalance);
                    lemonbalance = Integer.toString(a1.lemons);
                    lemonsamount.setText(lemonbalance);

                }
            });

            startday = (Button) findViewById(R.id.bstartday);
            startday.setOnClickListener(new View.OnClickListener() {

                /**
                 * Function to return boolean value based on user data.
                 * @param v
                 */
                @Override
                public void onClick(View v) {

                    nextdaycheck = true;

                }
            });

        }





        if(nextdaycheck == true) {

            stall = (ImageView) findViewById(R.id.stallpic);

            buyer = (ImageView) findViewById(R.id.buyerpic);

            seller = (ImageView) findViewById(R.id.sellerpic);


            if(buyer.getLeft() < 80)
            {
                for(int i = 80; i < 5; i-=10)
                {
                    //move buyer down
                }
            }
            else
            {
                for(int i = 0; i < 5; i+=10)
                {
                    // move buyer up
                }
            }

            finishday = (Button) findViewById(R.id.bfinday);
            finishday.setOnClickListener(new View.OnClickListener() {

                /**
                 * Function to return boolean value based on user data.
                 *
                 * @param v
                 */
                @Override
                public void onClick(View v) {

                    a1.useLemons();
                    nextdaycheck = false;



                }
            });


        }


        logo = (ImageView) findViewById(R.id.blogo);
        logo.setOnClickListener(new View.OnClickListener() {

            /**
             * Function to return boolean value based on user data.
             * @param v
             */
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SingleplayerActivity.this, MainMenuActivity.class);
                SingleplayerActivity.this.startActivity(i);

            }
        });






    }

    void setMoneybalance(TextView a, String b)
    {
        a.setText("$" + b);
    }



    /*
     * Activity state functions


    @Override
    protected void onPause() {
        super.onPause();

        if(mGameThread.getMode() == GameThread.STATE_RUNNING) {
            mGameThread.setState(GameThread.STATE_PAUSE);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        mGameView.cleanup();
        mGameView.removeSensor((SensorManager)getSystemService(Context.SENSOR_SERVICE));
        mGameThread = null;
        mGameView = null;
    }
*/

    /*
     * UI Functions


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, MENU_START, 0, R.string.menu_start);
        menu.add(0, MENU_STOP, 0, R.string.menu_stop);
        menu.add(0, MENU_RESUME, 0, R.string.menu_resume);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_START:
                mGameThread.doStart();
                return true;
            case MENU_STOP:
                mGameThread.setState(GameThread.STATE_LOSE,  getText(R.string.message_stopped));
                return true;
            case MENU_RESUME:
                mGameThread.unpause();
                return true;
        }

        return false;
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // Do nothing if nothing is selected
    }

*/

}