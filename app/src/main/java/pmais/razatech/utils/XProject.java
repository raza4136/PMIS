package pmais.razatech.utils;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.davemorrissey.labs.subscaleview.ImageSource;

import java.util.List;

import pmais.razatech.R;

public class XProject extends AppCompatActivity {
    private PinView imageView;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xproject);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        List<PointF> XFactorList = Pref.loadPinPoints(this);
        imageView = findViewById(R.id.pinView);

        imageView.setImage(ImageSource.uri("/storage/emulated/0/DiSynergyMap/Floor_1.jpg"));
        imageView.loadXProject(XFactorList);


        final GestureDetector gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                Pref.addPinPoints(sCoord, XProject.this);
                imageView.setPin(sCoord);

                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                imageView.deletePin(sCoord);
                Pref.removePinPoint(sCoord,XProject.this);
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if (imageView.isReady()) {
                    PointF sCoord = imageView.viewToSourceCoord(e.getX(), e.getY());
                    Toast.makeText(getApplicationContext(), "Double tap: " + ((int) sCoord.x) + ", " + ((int) sCoord.y), Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
        imageView.setOnTouchListener((View view, MotionEvent motionEvent) -> {
            gestureDetector.onTouchEvent(motionEvent);
            return false;
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
