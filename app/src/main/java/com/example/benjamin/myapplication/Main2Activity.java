package com.example.benjamin.myapplication;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main2Activity extends AppCompatActivity {
    private static final int NOTIF_ID=0;
    public RecyclerView rv;
    public static String URL=""


    public void findMoreBeer(View v){
        String url = URL;
        Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse( url ) );
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn_svc = (Button) findViewById(R.id.button2);
        rv = (RecyclerView) findViewById(R.id.rv_beer);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(new BeersAdapter(getBeersFromFiles()));

    }

    public void createServices(View v){

        GetBiersServices.startActionGetAllBiers(this);
        IntentFilter intentFilter = new IntentFilter(BIERS_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(),intentFilter);
    }
    public static final String BIERS_UPDATE="com.project-tp1.info3034-11.BIERS_UPDATE";
    public static final String TAG="BIERS_UPDATE";
    public class BierUpdate extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG,intent.getAction());
            NotificationCompat.Builder builder= (NotificationCompat.Builder) new  NotificationCompat.Builder(context).setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(getString(R.string.app_name))
                    .setContentText(getString(R.string.filesDown));
            NotificationManager nm =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nm.notify(NOTIF_ID,builder.build());
            ((BeersAdapter)(rv.getAdapter())).setNewBeer(getBeersFromFiles());

        }
    }

    public JSONArray getBeersFromFiles(){
        try{
            InputStream is = new FileInputStream(getCacheDir()+"/"+"bieres.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer,"UTF-8"));
        }catch (IOException e){
            e.printStackTrace();
            return new JSONArray();
        } catch (JSONException e) {
            e.printStackTrace();
        } return new JSONArray();
    }

    private class BeersAdapter extends RecyclerView.Adapter<BeersAdapter.BeerHolder>{
        private JSONArray beer;

        public  BeersAdapter(JSONArray beer){
            this.beer = beer;
        }

        public void setNewBeer(JSONArray ju){
            beer=ju;
            notifyDataSetChanged();
        }


        @Override
        public BeerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new BeerHolder (LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_beer_element,parent,false));
        }

        @Override
        public void onBindViewHolder(BeerHolder holder, int position) {
            try {
                JSONObject jo = beer.getJSONObject(position);
                holder.name.setText(jo.getString("name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        @Override
        public int getItemCount() {
             return beer.length();
        }


        public class BeerHolder extends RecyclerView.ViewHolder {
            public TextView name;

            public BeerHolder(View itemView) {
                super(itemView);
                this.name = (TextView) itemView.findViewById(R.id.rv_beer_element_name);
            }
        }

    }

}
