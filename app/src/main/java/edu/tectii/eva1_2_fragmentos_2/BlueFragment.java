package edu.tectii.eva1_2_fragmentos_2;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlueFragment extends Fragment {

    Principal principal;
    Context context;

    String[] items = {"Items-1","Items-2","Items-3","Items-4","Items-5",
            "Items-6","Items-7","Items-8","Items-9","Items-10",
            "Items-11","Items-12","Items-13","Items-14","Items-15"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        principal = (Principal) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout llAzul = (LinearLayout) inflater.inflate(R.layout.fragment_blue, container, false);

        ListView listView = (ListView)  llAzul.findViewById(R.id.lstVwBlue);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1, items);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                principal.onMsgFromToMain("BLUE_FRAG",items[i]);
            }
        });
        return llAzul;
    }



}

