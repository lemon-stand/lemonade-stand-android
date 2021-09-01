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


    //game loop
    public spGame a1 = new spGame();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_singleplayer);



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

                    Intent i = new Intent(SingleplayerActivity.this, SingleplayerActivity2.class);
                    SingleplayerActivity.this.startActivity(i);

                }
            });


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