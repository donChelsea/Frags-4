package android.example.com.fragapp.frag;


import android.example.com.fragapp.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NextFragment extends Fragment {
    private TextView textView;
    private View rootView;
    private String userText;


    public NextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_next, container, false);
        textView = rootView.findViewById(R.id.frag_textview);

        Bundle args = getArguments();
        userText = args.getString("user text");
        textView.setText(userText);

        return rootView;
    }

}
