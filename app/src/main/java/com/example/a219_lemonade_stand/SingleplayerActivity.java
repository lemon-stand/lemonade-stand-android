package com.example.a219_lemonade_stand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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


    //game loop
    public spGame a1 = new spGame();

    private boolean nextdaycheck = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_singleplayer);

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

}