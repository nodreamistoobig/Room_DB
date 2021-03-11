package com.example.room_db;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    DB db;
    List<Product> products_list;
    List<Category> categories_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = DB.create(this, false);
        new Thread(){
            @Override
            public void run(){
                products_list = db.manager().selectAllProd();
                categories_list = db.manager().selectAllCat();
                setCursorInUIThread(products_list, categories_list);
            }
        }.start();
    }
    public void setCursorInUIThread(List<Product> products_list, List<Category> categories_list) {
        Context ctx = getApplicationContext();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                CategoryAdapter ctg_adapter = new CategoryAdapter(ctx, categories_list);
                ListView categories = findViewById(R.id.categories);
                categories.setAdapter(ctg_adapter);

                ProductsAdapter prd_adapter = new ProductsAdapter(ctx, products_list);
                ListView products = findViewById(R.id.products);
                products.setAdapter(prd_adapter);

                AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?>parent, View view, int position, long id){
                        int index = position+1;
                        Log.d("mytag", "Clicked on id: "+index);
                        new Thread() {
                            @Override
                            public void run(){
                                List<Product> prds = db.manager().selectByCategory(index);
                                setCursorInUIThread(prds, categories_list);
                            }

                        }.start();


                    }
                };
                categories.setOnItemClickListener(listener);

            }
        });
    }

    public void onClick(View v){
        setCursorInUIThread(products_list, categories_list);
    }

}

