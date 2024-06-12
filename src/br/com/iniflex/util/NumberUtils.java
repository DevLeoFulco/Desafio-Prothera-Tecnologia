package br.com.iniflex.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberUtils {
    private static final DecimalFormat formatter;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        formatter = new DecimalFormat("#,##0.00", symbols);
    }

    public static String formatarNumero(BigDecimal numero) {
        return formatter.format(numero);
    }
}