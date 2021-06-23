package htl.gkr.a3cfitness_ernaehrungapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ernaehrungstippsfragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.ernaehrungstippsfragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[]  city = {"*Ernährung ist wichtiger als Training.","*Achte auf eine ausgewogene Ernährung.","*Um Muskel aufzubauen, musst du im Kalorienüberschuss sein.","*Berechne deinen Tagesbedarf, um genau deinen Kalorienbedarf zu wissen.","*Ernähre dich abwechslungsreich.","*Das Konsum von Süssigkeiten und Fleisch sollte nicht übertrieben werden."};

        ListView listView=(ListView)view.findViewById(R.id.listviewernährungstipps);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,city);
        listView.setAdapter(adapter);
    }
}

