package com.tintuc.anew;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.tintuc.anew.adapter.MenuAdapter;
import com.tintuc.anew.adapter.PostAdapter;
import com.tintuc.anew.api.NewsApi;
import com.tintuc.anew.com.tintuc.interfaces.AddapterListener;
import com.tintuc.anew.com.tintuc.interfaces.HttpCallback;
import com.tintuc.entity.MenuEntity;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    private ImageView imgMenu;
    private RecyclerView rvMenu;
    private RecyclerView rvPost;

    private MenuAdapter menuAdapter;
    private List<MenuEntity> menuEntities = new ArrayList<>();
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MenuEntity menuThoiSu = new MenuEntity();

        menuThoiSu.setId(1);
        menuThoiSu.setTitle("Thời sự");
        menuThoiSu.setSelected(true);

        MenuEntity menuTheThao = new MenuEntity();
        menuTheThao.setId(1);
        menuTheThao.setTitle("Thể Thao");

        MenuEntity menuKinhTe = new MenuEntity();
        menuKinhTe.setId(1);
        menuKinhTe.setTitle("Kinh Tế");

        MenuEntity menuChinhTri = new MenuEntity();
        menuChinhTri.setId(1);
        menuChinhTri.setTitle("Chính Trị");


        menuEntities.add(menuThoiSu);
        menuEntities.add(menuTheThao);
        menuEntities.add(menuKinhTe);
        menuEntities.add(menuChinhTri);
        imgMenu =findViewById(R.id.img_menu);


        //SLIDING-MENU
      final   SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen._12sdp);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen._60sdp);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.layout_menu);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
            }
        });
        menuAdapter = new MenuAdapter(menuEntities, new AddapterListener() {
            @Override
            public void onItemClickListener(Object o, int pos, RecyclerView.ViewHolder holder) {
                //reset
                for (int i=0;i<menuEntities.size();++i){

                    MenuEntity entity = menuEntities.get(i);
                    entity.setSelected(false);
                }
                menu.toggle();
                MenuEntity menuEntity = (MenuEntity)o;
                menuEntity.setSelected(true);
                menuAdapter.notifyDataSetChanged();
            }
        });
        rvMenu = (RecyclerView)menu.findViewById(R.id.rv_menu);
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        rvMenu.setItemAnimator( new DefaultItemAnimator());
        rvMenu.setAdapter(menuAdapter);

        rvPost = findViewById(R.id.rv_post);
        rvPost.setLayoutManager(new LinearLayoutManager(this));
        rvPost.setItemAnimator( new DefaultItemAnimator());
        rvPost.setAdapter( new PostAdapter());


        NewsApi.apiEx(context,1,10,0, new HttpCallback() {
            @Override
            public void onSucess(final String s) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONArray jsonArray = new JSONArray(s);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }

            @Override
            public void onStart() {

            }

            @Override
            public void onFailure(Request request, IOException e) {

            }
        });
    }
}
