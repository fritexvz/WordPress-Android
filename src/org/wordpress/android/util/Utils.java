package org.wordpress.android.util;

import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.util.TypedValue;

import org.wordpress.android.BuildConfig;
import org.wordpress.android.R;
import org.wordpress.android.WordPress;

import java.util.Comparator;
import java.util.Map;

public class Utils {

    public static Comparator<Object> BlogNameComparator = new Comparator<Object>() {
        
        public int compare(Object blog1, Object blog2) {
 
            Map<Object, Object> blogMap1 = (Map<Object, Object>)blog1;
            Map<Object, Object> blogMap2 = (Map<Object, Object>)blog2;
            
            String blogName1 = blogMap1.get("blogName").toString();
            if (blogName1.length() == 0) {
                blogName1 = blogMap1.get("url").toString();
            }
            
            String blogName2 = blogMap2.get("blogName").toString();
            if (blogName2.length() == 0) {
                blogName2 = blogMap2.get("url").toString();
            }
            
          return blogName1.compareToIgnoreCase(blogName2);
 
        }
 
    };
 
    // logic below based on login in WPActionBarActivity.java
    public static boolean isXLarge(Context context) {
        if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE)
            return true;
        return false;
    }
    
    public static boolean isLandscape(Context context) {
        return (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
    }

    public static boolean isTablet() {
        return WordPress.getContext().getResources().getInteger(R.integer.isTablet) == 1;
    }
    
    public static float dpToPx(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, WordPress.getContext().getResources().getDisplayMetrics());
    }
    
    public static float spToPx(float sp) {
        float scaledDensity = WordPress.getContext().getResources().getDisplayMetrics().scaledDensity;
        return sp * scaledDensity;
   }
    
    public static int getSmallestWidthDP() {
        return WordPress.getContext().getResources().getInteger(R.integer.smallest_width_dp);
    }

    /*
     * Return true if Debug build. false otherwise.
     * 
     * ADT (r17) or Higher => BuildConfig.java is generated automatically by Android build tools, and is placed into the gen folder.
     *  
     * BuildConfig containing a DEBUG constant that is automatically set according to your build type. 
     * You can check the (BuildConfig.DEBUG) constant in your code to run debug-only functions.
     */
    public static boolean isDebugBuild() {
        if (BuildConfig.DEBUG) {
            return true;
        }
        return false;
    }
}