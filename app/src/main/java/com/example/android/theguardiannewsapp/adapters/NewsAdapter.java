package com.example.android.theguardiannewsapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.theguardiannewsapp.R;
import com.example.android.theguardiannewsapp.model.News;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * A {@link NewsAdapter} knows how to create a lit item layout for news in the data source
 * <p>
 * These list item layouts will be provided to an adapter view like Listview to be
 * displayed to the user
 * </p>
 */
public class NewsAdapter extends ArrayAdapter<News> {
    /**
     * constructs a new {@link NewsAdapter}
     *
     * @param context of the app
     * @param news    the list of news, the data source for the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * @param position    of the current item
     * @param convertView the view that gets reused
     * @param parent
     * @return a list item view that displays information about the {@News} at the given position
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //first check if there is any re usable views, in case there is not any
        //inflate a new view from the news_list.xml
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate
                    (R.layout.news_list, parent, false);
        }

        // get all the textViews in the news_list with their respective ids to use them later
        TextView headlineTextView = convertView.findViewById(R.id.headline_textView);
        TextView authorNameTextView = convertView.findViewById(R.id.author_name_textView);
        TextView dateTextView = convertView.findViewById(R.id.date_textView);
        TextView sectionTextView = convertView.findViewById(R.id.section_textView);

        //get a refrence to the News item at the current postion
        News currentNewsItem = getItem(position);

        //set each text view using the getter methods
        headlineTextView.setText(currentNewsItem.getmHeadline());
        authorNameTextView.setText("Written by : " + currentNewsItem.getmAuthor());

        sectionTextView.setText(currentNewsItem.getmSection());

        //Date dateObject = new Date(currentNewsItem.getmDate());

        dateTextView.setText(formatDate(currentNewsItem.getmDate()));


        return convertView;
    }

    private static String formatDate(String rawDate) {
        String jsonDatePattern = "yyyy-MM-dd'T'HH:mm:ss'Z'";
        SimpleDateFormat jsonFormatter = new SimpleDateFormat(jsonDatePattern);
        try {
            Date parsedJsonDate = jsonFormatter.parse(rawDate);
            String finalDatePattern = "MMM d, yyy";
            SimpleDateFormat finalDateFormatter = new SimpleDateFormat(finalDatePattern);
            return finalDateFormatter.format(parsedJsonDate);
        } catch (ParseException e) {
            Log.e("QueryUtils", "Error parsing JSON date: ", e);
            return "";
        }
    }
}
