package android.example.com.fragapp.frag;


import android.example.com.fragapp.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private EditText editText;
    private Button button;
    private View rootView;
    private static final String BUNDLE_KEY = "user text";


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        editText = rootView.findViewById(R.id.frag_edittext);
        button = rootView.findViewById(R.id.frag_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextFragment nextFragment = new NextFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

                Bundle args = new Bundle();
                String userText = editText.getText().toString().trim();
                args.putString(BUNDLE_KEY, userText);
                nextFragment.setArguments(args);
                fragmentTransaction.replace(R.id.main_container, nextFragment).addToBackStack("null");
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

}
