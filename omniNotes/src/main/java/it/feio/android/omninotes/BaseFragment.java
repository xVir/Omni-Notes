package it.feio.android.omninotes;

import android.support.v4.app.Fragment;
import com.squareup.leakcanary.RefWatcher;

import ai.api.model.AIResponse;


/**
 * Created by fede on 10/05/15.
 */
public class BaseFragment extends Fragment {


	@Override
	public void onStart() {
		super.onStart();
		// Analytics tracking
		((OmniNotes) getActivity().getApplication()).getTracker().trackScreenView(getClass().getName());
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		RefWatcher refWatcher = OmniNotes.getRefWatcher();
		refWatcher.watch(this);
	}

	protected void processVoiceCommand(AIResponse aiResponse) {
		// Should be overridden
	}

}
