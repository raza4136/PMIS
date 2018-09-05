package pmais.razatech.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.util.ArrayList;
import java.util.List;

import pmais.razatech.R;


public class PinView extends SubsamplingScaleImageView {

    private final Paint paint = new Paint();


    private final PointF vPin = new PointF();
    private List<PointF> sPin = new ArrayList<>();

    private Bitmap pin;

    public PinView(Context context) {
        this(context, null);
    }

    public PinView(Context context, AttributeSet attr) {
        super(context, attr);
        initialise();
    }

    //    @Override
//    public boolean onTouch(View view, MotionEvent motionEvent) {
//        float x = (motionEvent.getX()/view.getWidth())*100;
//        float y = (motionEvent.getY()/view.getHeight())*100;
//        sPin.add(new PointF(x,y));
//        initialise();
//        invalidate();
//        return false;
//    }
    public static boolean calculateDifference(PointF savedPoint, PointF receivedPoint) {
        float xDifference = Math.abs(savedPoint.x - receivedPoint.x);
        float yDifference = Math.abs(savedPoint.y - receivedPoint.y);
        if (xDifference < 70) {
            if (yDifference < 70) {
                return true;
            }
        }

        return false;
    }

    public void setPin(PointF sPin) {
        this.sPin.add(sPin);
        initialise();
        invalidate();
    }

    public void loadXProject(List<PointF> xPins) {
        sPin = xPins;
        initialise();
        invalidate();
    }

    public void deletePin(PointF sPin) {
        for (int i = 0; i < this.sPin.size(); i++) {
            PointF point = this.sPin.get(i);
            if (calculateDifference(point, sPin)) {
                this.sPin.remove(i);
            }
        }
        initialise();
        invalidate();
    }

    private void initialise() {
        float density = getResources().getDisplayMetrics().densityDpi;
        pin = BitmapFactory.decodeResource(this.getResources(), R.drawable.pin);
        float w = (density / 820f) * pin.getWidth();
        float h = (density / 820f) * pin.getHeight();
        pin = Bitmap.createScaledBitmap(pin, (int) w, (int) h, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Don't draw pin before image is ready so it doesn't move around during setup.
        if (!isReady()) {
            return;
        }
        paint.setAntiAlias(true);
        for (PointF point : sPin) {
            if (sPin != null && pin != null) {
                sourceToViewCoord(point, vPin);
                float vX = vPin.x - (pin.getWidth() / 2);
                float vY = vPin.y - pin.getHeight();
                canvas.drawBitmap(pin, vX, vY, paint);
            }
        }
        canvas.save();
        canvas.restore();
    }

    public List<PointF> getPoints() {
        return this.sPin;
    }
}
