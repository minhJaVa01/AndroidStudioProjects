package com.tintuc.anew.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tintuc.anew.R;
import com.tintuc.anew.com.tintuc.interfaces.AddapterListener;
import com.tintuc.entity.MenuEntity;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter {
    private AddapterListener listener;
    private List<MenuEntity> menuEntities;
    public MenuAdapter(List<MenuEntity> menuEntities ,AddapterListener listener){
        this.listener =listener;
        this.menuEntities = menuEntities;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v =layoutInflater.inflate(R.layout.item_menu,null);
        return new MenuViewHoder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int i) {
        final MenuViewHoder menuViewHolder = (MenuViewHoder)holder;
        final MenuEntity menuEntity =menuEntities.get(i);
        String title = menuEntity.getTitle();
        menuViewHolder.tvMenu.setText(title);

        if(menuEntity.isSelected()){
            menuViewHolder.rlItem_menu.setBackgroundResource(R.color.colorPrimary);
        }else{
            menuViewHolder.rlItem_menu.setBackgroundResource(android.R.color.white);
        }

        menuViewHolder.rlItem_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onItemClickListener(menuEntity,i,menuViewHolder);
                }
            }
        });
    }
    private class MenuViewHoder extends RecyclerView.ViewHolder{
        RelativeLayout rlItem_menu ;
        TextView tvMenu;

        public MenuViewHoder(@NonNull View itemView) {

            super(itemView);
            rlItem_menu = itemView.findViewById(R.id.rl_item_menu);
            tvMenu = (TextView) itemView.findViewById(R.id.tv_menu);
        }
    }

    @Override
    public int getItemCount() {
        return menuEntities.size();
    }
}
