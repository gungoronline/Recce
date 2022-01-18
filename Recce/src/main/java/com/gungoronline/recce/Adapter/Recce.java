package com.gungoronline.recce.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.gungoronline.recce.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Recce {
    public static class BaseAdapt  extends BaseAdapter {
        private String TAG = getClass().getSimpleName();
        private ArrayList<?> arrayList;
        private Context context;
        private LayoutInflater li;
        private @LayoutRes
        int layout;
        private @Nullable
        int viewType;
        public static int LAYOUT1_CARDVIEW_1IMG_2TXT = 1;
        public static int LAYOUT2_SPINNER_1IMG_1TXT = 2;
        public static int LAYOUT_SAMPLE_1TXT = 3;
        public static int LAYOUT_SAMPLE_2TXT = 4;
        private ListView listView;

        public ListView setList(){
            this.listView = new ListView(context);
            this.listView.setAdapter(this);
            return this.listView;
        }

        private void Call(){
            this.ViewListener = null;
        }
        public BaseAdapt() {
            Call();
        }
        public BaseAdapt(ArrayList<?> arrayList, Context context, @LayoutRes int layout, int viewType) {
            Call();
            this.arrayList = arrayList;
            this.context = context;
            this.li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.layout = layout;
            this.viewType = viewType;
        }

        @Override
        public int getCount() {
            return this.arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return this.arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = null;
            if(this.layout!=-1 && this.layout!=0){
                v = this.li.inflate(this.layout, null);
                setView(v, position);
            }else if(this.viewType==LAYOUT1_CARDVIEW_1IMG_2TXT){
                v = this.li.inflate(R.layout.layout1_cardview_1img_2txt,null);
                HashMap<Integer, View> objects = new HashMap<>();
                for (int i = 0; i <((LinearLayout)v).getChildCount() ; i++) {
                    objects.put(((LinearLayout)v).getId(),((LinearLayout)v).getChildAt(i));
                }
                setFormView(v,position,objects);
            }else if(this.viewType==LAYOUT2_SPINNER_1IMG_1TXT){
                v = this.li.inflate(R.layout.layout2_spinner_1img_1txt,null);
                HashMap<Integer, View> objects = new HashMap<>();
                for (int i = 0; i <((LinearLayout)v).getChildCount() ; i++) {
                    objects.put(((LinearLayout)v).getId(),((LinearLayout)v).getChildAt(i));
                }
                setFormView(v,position,objects);
            }else if(this.viewType==LAYOUT_SAMPLE_1TXT){
                v = this.li.inflate(R.layout.layout_sample_1txt,null);
                HashMap<Integer, View> objects = new HashMap<>();
                for (int i = 0; i <((LinearLayout)v).getChildCount() ; i++) {
                    objects.put(((LinearLayout)v).getId(),((LinearLayout)v).getChildAt(i));
                }
                setFormView(v,position,objects);
            }else if(this.viewType==LAYOUT_SAMPLE_2TXT){
                v = this.li.inflate(R.layout.layout_sample_2txt,null);
                HashMap<Integer, View> objects = new HashMap<>();
                for (int i = 0; i <((LinearLayout)v).getChildCount() ; i++) {
                    objects.put(((LinearLayout)v).getId(),((LinearLayout)v).getChildAt(i));
                }
                setFormView(v,position,objects);
            }
            return v;
        }

        private void setView(View v, int position){
            if (ViewListener != null){
                ViewListener.onView(v, position);
            }
        }

        private void setFormView(View v, int position,HashMap<Integer,?> objects){
            if (ViewListener != null){
                ViewListener.onFormView(v, position,objects);
            }
        }

        private BaseAdapt.OnViewListener ViewListener;

        public interface OnViewListener
        {
            void onView(View v, int position);
            void onFormView(View v, int position,HashMap<Integer,?> objects);
        }

        public void setOnViewListener(@Nullable BaseAdapt.OnViewListener listener)
        {
            ViewListener = listener;
        }

        @Nullable
        public final BaseAdapt.OnViewListener getOnViewListener()
        {
            return ViewListener;
        }
    }
    public static class RecycleAdapt  extends RecyclerView.Adapter<RecycleAdapt.VH>{
        private String TAG = getClass().getSimpleName();
        private ArrayList<?> arrayList;
        private Context context;
        private @LayoutRes
        int layout;
        private @Nullable
        int viewType;
        public static int LAYOUT1_CARDVIEW_1IMG_2TXT = 1;
        public static int LAYOUT2_SPINNER_1IMG_1TXT = 2;
        public static int LAYOUT_SAMPLE_1TXT = 3;
        public static int LAYOUT_SAMPLE_2TXT = 4;

        private void Call(){
            this.BindListener = null;
        }
        public RecycleAdapt() {
            Call();
        }

        public RecycleAdapt(ArrayList<?> arrayList, Context context, int viewType) {
            Call();
            this.arrayList = arrayList;
            this.context = context;
            this.viewType = viewType;
        }

        public RecycleAdapt(ArrayList<?> arrayList, Context context, @LayoutRes int layout,int viewType) {
            Call();
            this.arrayList = arrayList;
            this.context = context;
            this.layout = layout;
            this.viewType = viewType;
        }

        @NonNull
        @Override
        public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(layout,null);
            return new VH(v);
        }

        @Override
        public void onBindViewHolder(@NonNull VH holder, int position) {
            if (BindListener != null)
            {
                BindListener.onBindView(holder, position);
            }
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public static class VH extends RecyclerView.ViewHolder{
            public VH(@NonNull View itemView) {
                super(itemView);
            }
        }
        private RecycleAdapt.OnBindListener BindListener;
        public interface OnBindListener
        {
            void onBindView(RecycleAdapt.VH v, int position);
        }

        public void setOnBindViewListener(@Nullable RecycleAdapt.OnBindListener listener)
        {
            BindListener = listener;
        }

        @Nullable
        public final RecycleAdapt.OnBindListener getOnBindListener()
        {
            return BindListener;
        }
    }
}
