// Generated by view binder compiler. Do not edit!
package com.simcoder.uber.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.simcoder.uber.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class NavHeaderMainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView imageViewDrawer;

  @NonNull
  public final TextView usernameDrawer;

  private NavHeaderMainBinding(@NonNull LinearLayout rootView, @NonNull ImageView imageViewDrawer,
      @NonNull TextView usernameDrawer) {
    this.rootView = rootView;
    this.imageViewDrawer = imageViewDrawer;
    this.usernameDrawer = usernameDrawer;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static NavHeaderMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static NavHeaderMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.nav_header_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static NavHeaderMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageViewDrawer;
      ImageView imageViewDrawer = rootView.findViewById(id);
      if (imageViewDrawer == null) {
        break missingId;
      }

      id = R.id.usernameDrawer;
      TextView usernameDrawer = rootView.findViewById(id);
      if (usernameDrawer == null) {
        break missingId;
      }

      return new NavHeaderMainBinding((LinearLayout) rootView, imageViewDrawer, usernameDrawer);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
