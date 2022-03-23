package com.sim2g.icbt.extensions;

import androidx.annotation.NonNull;

/**
 * Created by Farouk Sabiou on 3/4/22.
 */
public final class Utils {

    private Utils() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public static Float formatValue(String value) {
        return Float.valueOf(value);
    }
}
