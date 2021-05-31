package com.example.exercisefragmentcontact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailContactFragment extends Fragment implements ContactAdapter.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView txtName, txtPhone, txtEmail;
    ImageView imgAvatar;
    Contact detailContact;

    ImageView imgCall, imgMessage, imgEmail;

    public DetailContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailContactFragment newInstance(String param1, String param2) {
        DetailContactFragment fragment = new DetailContactFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    // Hứng dữ liệu bằng hàm Instance
    public static DetailContactFragment newInstance(Contact contact) {
        DetailContactFragment fragment = new DetailContactFragment();
        Bundle args = new Bundle();
        args.putString("name", contact.name);
        args.putString("phone", contact.phone);
        args.putString("email", contact.email);
        args.putInt("avatar", contact.avatar);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            detailContact = new Contact(getArguments().getString("name"), getArguments().getString("phone"),
                                        getArguments().getString("email"), getArguments().getInt("avatar", 0));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtName = view.findViewById(R.id.txtName);
        txtPhone = view.findViewById(R.id.txtPhone);
        txtEmail = view.findViewById(R.id.txtEmail);
        imgAvatar = view.findViewById(R.id.imgAvatar);

        txtName.setText(detailContact.name);
        txtPhone.setText(detailContact.phone);
        txtEmail.setText(detailContact.email);

        switch (detailContact.avatar)
        {
            case 0: imgAvatar.setImageResource(R.drawable.icon_female1); break;
            case 1: imgAvatar.setImageResource(R.drawable.icon_female2); break;
            case 2: imgAvatar.setImageResource(R.drawable.icon_male1); break;
            case 3: imgAvatar.setImageResource(R.drawable.icon_male2); break;
        }

        imgCall = view.findViewById(R.id.imgCall);
        imgMessage = view.findViewById(R.id.imgMessage);
        imgEmail = view.findViewById(R.id.imgEmail);

        imgCall.setImageResource(R.drawable.ic_baseline_call_24);
        imgMessage.setImageResource(R.drawable.ic_baseline_message_24);
        imgEmail.setImageResource(R.drawable.ic_baseline_email_24);
    }

    @Override
    public void setOnUserCallClick(Contact contact) {

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), detailContact.phone, Toast.LENGTH_SHORT).show();
            }
        });

        imgMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), detailContact.name, Toast.LENGTH_SHORT).show();
            }
        });

        imgEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), detailContact.email, Toast.LENGTH_SHORT).show();
            }
        });
    }
}