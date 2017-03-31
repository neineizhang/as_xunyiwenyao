package com.zll.xunyiwenyao.webservice;

import com.zll.xunyiwenyao.dbitem.Review;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kejund on 17/3/30.
 */

public class ReviewWebService {
    private static List<Review> reviewlist;

    static{
        reviewlist = new ArrayList<Review>();
        Review review = null;

        review = new Review("阿司匹林","过期");
        reviewlist.add(review);
    }

    public static void addReview(Review item){
        reviewlist.add(item);
    }

    public static List<Review> getAllReview(){
        return reviewlist;
    }

}
