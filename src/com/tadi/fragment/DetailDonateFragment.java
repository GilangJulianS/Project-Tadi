package com.tadi.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tadiproject.MainActivity;
import com.example.tadiproject.R;

public class DetailDonateFragment extends Fragment {
	
	public static int position;
	ImageView donateLogo;
	TextView donateTitle;
	TextView donateDescription;
	Button subscribeButton;
	Button donateButton;
	
	public DetailDonateFragment() {
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment_detail_donate, container, false);
		
		donateLogo = (ImageView)rootView.findViewById(R.id.detailDonateLogo);
		donateTitle = (TextView)rootView.findViewById(R.id.detailDonateTitle);
		donateDescription = (TextView)rootView.findViewById(R.id.detailDonateDescription);
		
		donateLogo.setImageResource(MainActivity.organizationItems.get(position).getDonateImage());
		donateTitle.setText(MainActivity.organizationItems.get(position).getTitle());
		donateDescription.setText(MainActivity.organizationItems.get(position).getDescription());
		
		subscribeButton = (Button)rootView.findViewById(R.id.subscribeButton);
		subscribeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new DialogConfirmSubscribeFragment().show(getFragmentManager(), "");
			}
		});
		
		donateButton = (Button)rootView.findViewById(R.id.donateButton);
		donateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager fm = getActivity().getSupportFragmentManager();
				fm.beginTransaction().replace(R.id.container, new DonateAmountFragment()).commit();
			}
		});
		
		return rootView;
		
	}
		
}
