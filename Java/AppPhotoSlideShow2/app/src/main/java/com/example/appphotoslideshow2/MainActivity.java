package com.example.appphotoslideshow2;



import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer temp;
   //nt vel=3000;
    boolean bloqimg=true;
    ImageView imgview;
    SeekBar barra;
    Button btn;
    MediaPlayer media;
    int Auxx = 0;
    boolean manual = true;
    long segundos;
    int x =0;
    Timer timer;
    int  velocidadini =0;
   int  velNueva= 1;
    int velocidadActual;
    int Index = 0;
    int[] img = {R.drawable.img1, R.drawable.img2, R.drawable.img3,R.drawable.img4, R.drawable.img5, R.drawable.img6,R.drawable.img7,R.drawable.img8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Iniciar();
    }
    void Iniciar(){
        imgview = findViewById(R.id.imgview);
        barra = findViewById(R.id.barra);
        btn = findViewById(R.id.btn);
        media = MediaPlayer.create(this,R.raw.melodia_zen);




        // Listener para el botón
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (manual) {
                   // timer = new Timer();
                    bloqimg = false;
                    // Cambiar a modo automático
                    manual = false;
                    barra.setVisibility(View.VISIBLE);
                    btn.setText("Cambiar a manual");
                    System.out.println("Automático");
                    media.start();

                   //     actualizarImagen(velNueva);


                } else {
                    // Cambiar a modo manual
                    manual = true;
                    barra.setVisibility(View.GONE);
                    btn.setText("Cambiar a automático");
                    System.out.println("Manual");
                    media.pause();


                }
            }
        });

        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (manual){
                    Auxx++;
                    animImg();
                }

            }
        });

        //Listener del seekbar
        barra.setMax(10);  // Establece el máximo de la barra a 10 para representar los diferentes niveles de velocidad
        barra.setProgress(velocidadini);
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if (!manual  &&  timer != null) {
                    timer.cancel();
                    timer.purge();

                }
                    actualizarImagen(barra.getProgress());
            /*    if (!manual) {
                    // Si estás en modo automático, actualiza la velocidad del temporizador
                    velNueva=progress;

                    actualizarImagen(velNueva);
                }
                if (progress<=0){
                    bloqimg= false;
                }else{
                    bloqimg=true;
                }*/

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Nada
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
              //  bloqimg = false;
            }
        });
        //Metodo para iniciar la repro automatica de imgs en funcion de seekbar
        //new Timer(barra.getProgress() * 1000);






    }
    //Metodo de animacion de imgs
    void animImg(){
        if (Auxx == img.length){
            Auxx =0;
        }
        Animation Out = AnimationUtils.loadAnimation(this, R.anim.slide_out);
        Animation In = AnimationUtils.loadAnimation(this, R.anim.slide_in);
        Out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgview.setImageResource(img[Auxx]);
                imgview.startAnimation(In);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imgview.startAnimation(Out);
    }


    private void actualizarImagen(int  vel) {
        System.out.println("Progress "+ barra.getProgress()) ;
        System.out.println("Nueva  "+ velNueva) ;
        System.out.println("11 "+ vel) ;



        if ( !manual) {
            // Resto del código del método...
           timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (!manual) {

                                Auxx++;
                                animImg();
                            }
                        }
                    });
                }
            }, 0, vel * 1000L);  // Multiplica por 1000 para convertir segundos a milisegundos

        }
        velNueva=vel;
    }

    public void reiniTimer( int velBarra) {

        System.out.println("00  "+ velBarra) ;

    }


    private int calcularvel() {
        int progreso = barra.getProgress();
        int retardoInicial = 2000;
        int retardoMaximo = 10000;
        return progreso;
    }

}



