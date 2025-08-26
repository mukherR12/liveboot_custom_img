package eu.chainfire.liveboot.shell;

import android.graphics.Color;
import android.os.Handler;

public class AsciiLogo {

    private final OnLineListener mOnLineListener;
    private final Handler mHandler;
    private final String[] mLines; // your 180×320 ASCII logo lines

    public AsciiLogo(OnLineListener listener, Handler handler, String[] lines) {
        mOnLineListener = listener;
        mHandler = handler;
        mLines = lines;
    }

    public void setReady() {
        // Feed all lines to the renderer
        mHandler.post(() -> {
            for (String line : mLines) {
                // Send each line to Runner's onLine()
                mOnLineListener.onLine(this, line, Color.WHITE);
            }
        });
    }

    public void destroy() {
        // Nothing to clean up for a static logo
    }
}