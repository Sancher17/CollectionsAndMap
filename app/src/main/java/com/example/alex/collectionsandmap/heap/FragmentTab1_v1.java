//package com.example.alex.collectionsandmap.heap;
//
//
//import android.app.ProgressDialog;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.GridLayout;
//
//import com.example.alex.collectionsandmap.R;
//import com.example.alex.collectionsandmap.model.MyData;
//import com.example.alex.collectionsandmap.utils.Logger;
//import com.example.alex.collectionsandmap.view.MainActivity;
//
//import java.util.ArrayList;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//
//
//public class FragmentTab1_v1 extends Fragment {
//    private static Logger LOGGER = new Logger(MainActivity.class);
//
//    CollectionsUtil md = new CollectionsUtil();
//    ArrayList<Integer> al = new ArrayList<>();
//    MyTask2 task;
//
//
//    @BindView(R.id.but1)
//    Button btn1;
//
//    @BindView(R.id.but2)
//    Button btn2;
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        final View view = inflater.inflate(R.layout.fragment_tab1, container, false);
//        LOGGER.log("onCreateView");
//        final GridLayout gl = view.findViewById(R.id.gridLayoutTab1);
//        ButterKnife.bind(this, gl);
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                btn1.setText(String.valueOf(md.addToStart(al)));
//                LOGGER.log("onClick ");
//                task = new MyTask2();
//                btn1.setText(String.valueOf(task.execute()));
//
//
//            }
//        });
//
//
//        //каждый view должен запустить метод
//
//
//        return view;
//    }
//
//    public class MyTask2 extends AsyncTask<Integer, Void, String> {
//
//        private Logger LOGGER = new Logger(MainActivity.class);
//
//        ProgressDialog pd;
//
//        CollectionsUtil md = new CollectionsUtil();
//        ArrayList al = new ArrayList();
//
//
//        int result = 0;
//
//        @Override
//        protected String doInBackground(Integer... number) {
//            LOGGER.log("doInBackground");
//            result = md.addToStart(al);
//            return null;
//        }
//
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            s = String.valueOf(result);
//            btn1.setText(s);
//            pd.dismiss();
//            LOGGER.log("onPostExecute " + s);
//
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            pd = ProgressDialog.show(getContext(), "", "Please Wait", false);
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//            super.onProgressUpdate(values);
//
//
//        }
//    }
//
//
//}
////        GridLayout grid = new GridLayout(3, 3, 10, 10);
////https://www.journaldev.com/13792/android-gridlayoutmanager-example
