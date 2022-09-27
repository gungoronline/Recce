# Recce
Recce is powerfull adapter !

- Project by [@serifgungor](https://github.com/serifgungor) and Generated in 27.09.2022.

## Buildings
1. - Listing on ListView by BaseAdapter
2. - Listing on Spinner by BaseAdapter
3. - Listing on RecyclerView by RecycleAdapter


### Listing on ListView by BaseAdapter

![Photto Image Cache](/images/ss1.png)

```
public class MainActivity extends AppCompatActivity {
    ArrayList<String> countries = new ArrayList<>();
    Recce.BaseAdapt baseAdapt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        countries.add("TÜRKİYE");
        countries.add("K.K.T.C.");
        countries.add("AZERBAYCAN");
        countries.add("GERMANY");
        countries.add("UNITED KINGDOM");
        countries.add("U.S.A.");

        baseAdapt = new Recce.BaseAdapt(
                countries,
                getApplicationContext(),
                -1,
                Recce.BaseAdapt.LAYOUT_SAMPLE_1TXT
        );

        baseAdapt.setOnViewListener(new Recce.BaseAdapt.OnViewListener() {
            @Override
            public void onView(View v, int position) {
                //if layout argument != 0 or -1
            }

            @Override
            public void onFormView(View v, int position, HashMap<Integer, ?> objects) {
                //if viewType argument is filled
                //if you dont known in layout objects, you write logd objects.toString()
                //Log.d("sa2",objects.toString());
                //D/sa2: {-1=android.widget.TextView{dd62fae V.ED..... ......ID 0,0-0,0 #7f0801ca app:id/tvSample1_tvTitle}}
                ((TextView)v.findViewById(R.id.tvSample1_tvTitle)).setText(countries.get(position));

                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"POS: "+position+" TEXT: "+countries.get(position),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        setContentView(baseAdapt.setList());
    }
}
```

### Listing on Spinner by BaseAdapter

![Photto Image Cache](/images/ss3.png)

```
class Country implements Serializable{
    private String name;
    private String flagUrl;

    public Country(String name, String flagUrl) {
        this.name = name;
        this.flagUrl = flagUrl;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }
}

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> countries = new ArrayList<>();
    Recce.BaseAdapt baseAdapt;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        sp = findViewById(R.id.spinner);

        countries.add(new Country("TÜRKİYE","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Flag_of_Turkey.svg/250px-Flag_of_Turkey.svg.png"));
        countries.add(new Country("UKRAİNE","https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Flag_of_Ukraine.svg/250px-Flag_of_Ukraine.svg.png"));
        countries.add(new Country("RUSSİA","https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/250px-Flag_of_Russia.svg.png"));
        countries.add(new Country("BULGARİA","https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Flag_of_Bulgaria.svg/250px-Flag_of_Bulgaria.svg.png"));
        countries.add(new Country("NORWAY","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Norway.svg/250px-Flag_of_Norway.svg.png"));

        baseAdapt = new Recce.BaseAdapt(
                countries,
                getApplicationContext(),
                -1,
                Recce.BaseAdapt.LAYOUT2_SPINNER_1IMG_1TXT
        );

        baseAdapt.setOnViewListener(new Recce.BaseAdapt.OnViewListener() {
            @Override
            public void onView(View v, int position) {

            }

            @Override
            public void onFormView(View v, int position, HashMap<Integer, ?> objects) {
                ImageView iv = v.findViewById(R.id.ivSpinner);
                TextView tv1 = v.findViewById(R.id.tvSpinner);

                Glide.with(v.getContext()).load(countries.get(position).getFlagUrl()).into(iv);
                tv1.setText(countries.get(position).getName());
            }
        });
        sp.setAdapter(baseAdapt);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),countries.get(i).getName(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
```
	
	
### Listing on RecyclerView by RecycleAdapter


	
![Photto Image Cache](/images/ss2.png)

```
class Blog implements Serializable{
    private String imageUrl;
    private String title;
    private String description;

    public Blog(String imageUrl, String title,String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.description = description;
    }

    public Blog() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

public class MainActivity extends AppCompatActivity {

    ArrayList<Blog> blogs = new ArrayList<>();
    Recce.RecycleAdapt recycleAdapt;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recyclerView);

        blogs.add(new Blog("https://images.unsplash.com/photo-1539571696357-5a69c17a67c6","Blog1","desc1"));
        blogs.add(new Blog("https://images.unsplash.com/photo-1534528741775-53994a69daeb","Blog2","desc2"));
        blogs.add(new Blog("https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d","Blog3","desc3"));
        blogs.add(new Blog("https://images.unsplash.com/photo-1519085360753-af0119f7cbe7","Blog4","desc4"));
        blogs.add(new Blog("https://images.unsplash.com/photo-1589156288859-f0cb0d82b065","Blog5","desc5"));

        recycleAdapt = new Recce.RecycleAdapt(
                blogs,
                getApplicationContext(),
                R.layout.layout1_cardview_1img_2txt,-1
        );

        recycleAdapt.setOnBindViewListener(new Recce.RecycleAdapt.OnBindListener() {
            @Override
            public void onBindView(Recce.RecycleAdapt.VH v, int position) {
                ImageView iv = v.itemView.findViewById(R.id.layout1_iv);
                TextView tv1 = v.itemView.findViewById(R.id.layout1_tv1);
                TextView tv2 = v.itemView.findViewById(R.id.layout1_tv2);

                Glide.with(v.itemView.getContext()).load(blogs.get(position).getImageUrl()).into(iv);
                tv1.setText(blogs.get(position).getTitle());
                tv2.setText(blogs.get(position).getDescription());

                v.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),tv1.getText(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        rv.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL));
        rv.setAdapter(recycleAdapt);

    }
}

```

