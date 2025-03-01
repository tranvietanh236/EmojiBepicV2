// Generated by data binding compiler. Do not edit!
package com.app.friendschat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.app.friendschat.R;
import com.app.friendschat.ui.emoji.EmojiViewModel;
import com.app.friendschat.utils.custom_sticker.StickerView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class ActivityEmojiBepicNewBinding extends ViewDataBinding {
  @NonNull
  public final Guideline g1;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final ImageView ivDeleteEmoji;

  @NonNull
  public final ImageView ivFlipHorizontal;

  @NonNull
  public final ImageView ivFlipVertical;

  @NonNull
  public final ImageView ivLockEmoji;

  @NonNull
  public final ImageView ivMore;

  @NonNull
  public final ImageView ivOption;

  @NonNull
  public final ImageView ivRefresh;

  @NonNull
  public final RelativeLayout llOptions;

  @NonNull
  public final RelativeLayout rlDelete;

  @NonNull
  public final RelativeLayout rlEmoji;

  @NonNull
  public final RelativeLayout rlHeader;

  @NonNull
  public final RelativeLayout rlLock;

  @NonNull
  public final RelativeLayout rlOptionHeader;

  @NonNull
  public final RelativeLayout rlOptions;

  @NonNull
  public final RelativeLayout rlRecent;

  @NonNull
  public final RecyclerView rvIcon;

  @NonNull
  public final RecyclerView rvOptions;

  @NonNull
  public final StickerView stickerView;

  @NonNull
  public final TextView tvCreate;

  @NonNull
  public final TextView tvOption;

  @NonNull
  public final View view1;

  @NonNull
  public final View view2;

  @NonNull
  public final ViewPager2 vpIcon;

  @Bindable
  protected EmojiViewModel mViewModel;

  protected ActivityEmojiBepicNewBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Guideline g1, ImageView ivBack, ImageView ivDeleteEmoji, ImageView ivFlipHorizontal,
      ImageView ivFlipVertical, ImageView ivLockEmoji, ImageView ivMore, ImageView ivOption,
      ImageView ivRefresh, RelativeLayout llOptions, RelativeLayout rlDelete,
      RelativeLayout rlEmoji, RelativeLayout rlHeader, RelativeLayout rlLock,
      RelativeLayout rlOptionHeader, RelativeLayout rlOptions, RelativeLayout rlRecent,
      RecyclerView rvIcon, RecyclerView rvOptions, StickerView stickerView, TextView tvCreate,
      TextView tvOption, View view1, View view2, ViewPager2 vpIcon) {
    super(_bindingComponent, _root, _localFieldCount);
    this.g1 = g1;
    this.ivBack = ivBack;
    this.ivDeleteEmoji = ivDeleteEmoji;
    this.ivFlipHorizontal = ivFlipHorizontal;
    this.ivFlipVertical = ivFlipVertical;
    this.ivLockEmoji = ivLockEmoji;
    this.ivMore = ivMore;
    this.ivOption = ivOption;
    this.ivRefresh = ivRefresh;
    this.llOptions = llOptions;
    this.rlDelete = rlDelete;
    this.rlEmoji = rlEmoji;
    this.rlHeader = rlHeader;
    this.rlLock = rlLock;
    this.rlOptionHeader = rlOptionHeader;
    this.rlOptions = rlOptions;
    this.rlRecent = rlRecent;
    this.rvIcon = rvIcon;
    this.rvOptions = rvOptions;
    this.stickerView = stickerView;
    this.tvCreate = tvCreate;
    this.tvOption = tvOption;
    this.view1 = view1;
    this.view2 = view2;
    this.vpIcon = vpIcon;
  }

  public abstract void setViewModel(@Nullable EmojiViewModel viewModel);

  @Nullable
  public EmojiViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static ActivityEmojiBepicNewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_emoji_bepic_new, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static ActivityEmojiBepicNewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<ActivityEmojiBepicNewBinding>inflateInternal(inflater, R.layout.activity_emoji_bepic_new, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityEmojiBepicNewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.activity_emoji_bepic_new, null, false, component)
   */
  @NonNull
  @Deprecated
  public static ActivityEmojiBepicNewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<ActivityEmojiBepicNewBinding>inflateInternal(inflater, R.layout.activity_emoji_bepic_new, null, false, component);
  }

  public static ActivityEmojiBepicNewBinding bind(@NonNull View view) {
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
  public static ActivityEmojiBepicNewBinding bind(@NonNull View view, @Nullable Object component) {
    return (ActivityEmojiBepicNewBinding)bind(component, view, R.layout.activity_emoji_bepic_new);
  }
}
