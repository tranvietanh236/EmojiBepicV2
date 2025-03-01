// Generated by data binding compiler. Do not edit!
package com.app.friendschat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.app.friendschat.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ItemLayerBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivLayer;

  @NonNull
  public final ImageView ivShowLayer;

  @NonNull
  public final ImageView ivSwap;

  @NonNull
  public final ProgressBar pbLoading;

  @NonNull
  public final RelativeLayout rlLayer;

  @NonNull
  public final TextView tvName;

  protected ItemLayerBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView ivLayer, ImageView ivShowLayer, ImageView ivSwap, ProgressBar pbLoading,
      RelativeLayout rlLayer, TextView tvName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivLayer = ivLayer;
    this.ivShowLayer = ivShowLayer;
    this.ivSwap = ivSwap;
    this.pbLoading = pbLoading;
    this.rlLayer = rlLayer;
    this.tvName = tvName;
  }

  @NonNull
  public static ItemLayerBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_layer, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ItemLayerBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ItemLayerBinding>inflateInternal(inflater, R.layout.item_layer, root, attachToRoot, component);
  }

  @NonNull
  public static ItemLayerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.item_layer, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ItemLayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ItemLayerBinding>inflateInternal(inflater, R.layout.item_layer, null, false, component);
  }

  public static ItemLayerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static ItemLayerBinding bind(@NonNull View view, @Nullable Object component) {
    return (ItemLayerBinding)bind(component, view, R.layout.item_layer);
  }
}
