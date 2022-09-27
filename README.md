# Recce
Recce is powerfull adapter !

- Project by [@serifgungor](https://github.com/serifgungor) and Generated in 27.09.2022.

## Buildings
1. - Listing on ListView by BaseAdapter
2. -

### Listing on ListView by BaseAdapter
#### LAYOUT_SAMPLE_1TXT
![Photto Image Cache](/images/ss1.png)
<details>
	<summary>Click here for LAYOUT_SAMPLE_1TXT</summary>
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

</details>

