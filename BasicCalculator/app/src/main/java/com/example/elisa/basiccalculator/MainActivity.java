package com.example.elisa.basiccalculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            btnSuma, btnResta, btnMultiplica, btnDivision, btnIgual,
            btnClear, btnSigno, btnPunto, pi, rand, expdiez, cuadrado,
            cubo, raiz, seno, coseno, tangente, senoh, cosenoh, tangenteh;
    TextView display;
    Boolean flag1, flag2, nuevoNumero;
    String operacion;
    Double num1, num2, resultado;

    private void cargarComponentes() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnSuma = (Button) findViewById(R.id.btnSumar);
        btnResta = (Button) findViewById(R.id.btnRestar);
        btnMultiplica = (Button) findViewById(R.id.btnMultiplicar);
        btnDivision = (Button) findViewById(R.id.btnDividir);
        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnClear = (Button) findViewById(R.id.btnC);
        btnSigno = (Button) findViewById(R.id.btnSigno);
        btnPunto = (Button) findViewById(R.id.btnPunto);
        display = (TextView) findViewById(R.id.textView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.calculadora_cientifica);
            getVistasLand();
        } else {
            setContentView(R.layout.content_main);
        }

        cargarComponentes();

        flag1 = flag2 = false;
        nuevoNumero = true;
        display.setText("0");

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMultiplica.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnSigno.setOnClickListener(this);
        btnPunto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String entrada = (String) ((Button) view).getText();
        switch (view.getId()) {
            case R.id.btnSumar:
            case R.id.btnRestar:
            case R.id.btnMultiplicar:
            case R.id.btnDividir:
            case R.id.btnIgual:
                nuevoNumero = true;
                flag1 = false;
                if (flag2) {
                    num2 = Double.parseDouble(display.getText().toString());
                    mostrarResultado();
                    num1 = resultado;
                } else {
                    num1 = Double.parseDouble(display.getText().toString());
                    flag2 = true;
                }
                operacion = entrada;
                break;
            case R.id.btnC:
                display.setText("0");
                nuevoNumero = true;
                num1 = num2 = 0.0;
                flag1 = flag2 = false;
                break;
            case R.id.btnSigno:
                resultado = Double.parseDouble(display.getText().toString()) * -1;
                display.setText(Double.toString(resultado));
                break;
            case R.id.btnPunto:
                if (display.getText().toString().indexOf(".") < 0)
                    display.setText(display.getText() + ".");
                break;
            case R.id.pi:
                display.setText(Double.toString(Math.PI));
                break;
            case R.id.numRand:
                display.setText(Double.toString(Math.random()));
                break;
            case R.id.expdiez:
                display.setText(Double.toString(Math.pow(10, Double.parseDouble(display.getText().toString()))));
                break;
            case R.id.cuadrado:
                display.setText(Double.toString(Math.pow(Double.parseDouble(display.getText().toString()), 2)));
                break;
            case R.id.cubo:
                display.setText(Double.toString(Math.pow(Double.parseDouble(display.getText().toString()), 3)));
                break;
            case R.id.raizCuadrada:
                if (Double.parseDouble(display.getText().toString()) > 0)
                    display.setText(Double.toString(Math.sqrt(Double.parseDouble(display.getText().toString()))));
                break;
            case R.id.seno:
                if (Pattern.compile("^(\\-)?\\d+|^(\\-)?\\d+\\.?\\d+").matcher(display.getText().toString()).matches()) {
                    if (display.getText().toString().contains("."))
                        display.setText(Double.toString(Math.sin(Math.toRadians(Double.parseDouble(display.getText().toString())))));
                    else
                        display.setText(Double.toString(Math.sin(Math.toRadians(Integer.parseInt(display.getText().toString())))));
                }
                break;
            case R.id.coseno:
                if (Pattern.compile("^(\\-)?\\d+|^(\\-)?\\d+\\.?\\d+").matcher(display.getText().toString()).matches()) {
                    if (display.getText().toString().contains("."))
                        display.setText(Double.toString(Math.cos(Math.toRadians(Double.parseDouble(display.getText().toString())))));
                    else
                        display.setText(Double.toString(Math.cos(Math.toRadians(Integer.parseInt(display.getText().toString())))));
                }
                break;
            case R.id.tangente:
                if (Pattern.compile("^(\\-)?\\d+|^(\\-)?\\d+\\.?\\d+").matcher(display.getText().toString()).matches()) {
                    if (!display.getText().equals("90") || !display.getText().equals("270")) {
                        if (display.getText().toString().contains("."))
                            display.setText(Double.toString(Math.tan(Math.toRadians(Double.parseDouble(display.getText().toString())))));
                        else
                            display.setText(Double.toString(Math.tan(Math.toRadians(Integer.parseInt(display.getText().toString())))));
                    }
                }
                break;
            case R.id.senoh:
                display.setText(Double.toString(Math.sinh(Double.parseDouble(display.getText().toString()))));
                break;
            case R.id.cosenoh:
                display.setText(Double.toString(Math.cosh(Double.parseDouble(display.getText().toString()))));
                break;
            case R.id.tangenteh:
                display.setText(Double.toString(Math.tanh(Double.parseDouble(display.getText().toString()))));
                break;
            default:
                if (nuevoNumero) {
                    display.setText(entrada);
                    nuevoNumero = false;
                } else {
                    if (display.getText().length() < 10)
                        display.setText(display.getText() + entrada);
                }
        }
    }

    private void mostrarResultado() {
        switch (operacion) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                resultado = num1 / num2;
                break;
            default:
                break;
        }
        display.setText(Double.toString(resultado));
    }

    private void getVistasLand() {
        pi = (Button) findViewById(R.id.pi);
        rand = (Button) findViewById(R.id.numRand);
        expdiez = (Button) findViewById(R.id.expdiez);
        cuadrado = (Button) findViewById(R.id.cuadrado);
        cubo = (Button) findViewById(R.id.cubo);
        raiz = (Button) findViewById(R.id.raizCuadrada);
        seno = (Button) findViewById(R.id.seno);
        coseno = (Button) findViewById(R.id.coseno);
        tangente = (Button) findViewById(R.id.tangente);
        senoh = (Button) findViewById(R.id.senoh);
        cosenoh = (Button) findViewById(R.id.cosenoh);
        tangenteh = (Button) findViewById(R.id.tangenteh);

        pi.setOnClickListener(this);
        rand.setOnClickListener(this);
        expdiez.setOnClickListener(this);
        cuadrado.setOnClickListener(this);
        cubo.setOnClickListener(this);
        raiz.setOnClickListener(this);
        seno.setOnClickListener(this);
        coseno.setOnClickListener(this);
        tangente.setOnClickListener(this);
        senoh.setOnClickListener(this);
        cosenoh.setOnClickListener(this);
        tangenteh.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
