package eu.chainfire.liveboot.shell;

import android.graphics.Color;
import android.os.Handler;

public class AsciiLogo {

    private final OnLineListener mOnLineListener;
    private final Handler mHandler;
    private final String[] mLines;

    public AsciiLogo(OnLineListener listener, Handler handler, String[] lines) {
        mOnLineListener = listener;
        mHandler = handler;
        mLines = lines;
    }

    public void setReady() {
        // feed lines to renderer
        mHandler.post(() -> {
            for (String line : mLines) {
                mOnLineListener.onLine(this, line, Color.WHITE);
            }
        });
    }

    public void destroy() {
        // nothing to clean up for a static logo
    }
}
