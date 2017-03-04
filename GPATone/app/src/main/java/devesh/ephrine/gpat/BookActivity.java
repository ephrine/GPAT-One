package devesh.ephrine.gpat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.ads.mediation.facebook.FacebookAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class BookActivity extends AppCompatActivity {
    ListView listView;
    ListView listView1;
    ListView listView2;
    ListView listView3;
    ListView listView4;
    ListView listView5;
    ListView listView6;
    ListView listView7;
    ListView listView8;
    ListView listView9;
    ListView listView10;
    ListView listView11;
    ListView listView12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
AdLoad();
        // Pharmacology List view

        listView = (ListView) findViewById(R.id.listview1);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] pharmacologylist = new String[] {
                "1. Goodman & Gilman’s The Pharmacological Basis of Therapeutics",
                "2. Color Atlas of Pharmacology, 3rd Edition",
                "3. Pharmacology by rang and dale (6th edition)",
                "4. Basic and clinical Pharmacology By Katzung",
                "5. Lippincott’s Illustrated Reviews: Pharmacology, 4th Edition",
                "6. Stockly drug interactions",
                "7. Medical Pharmacology at a Glance",
                "8. Oxford Medical Dictionary",
                "9. Herbal- Drug interaction",
                "10.Drug Class Review",
                "11.Essential of Medical Pharmacology by KD Tripathi (Famous book in INDIA)",
                //"12. Principals of Pharmacology by HL Sharma & KK Sharma (Paras Medical Publishers)",

        };



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,pharmacologylist);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                /*/ Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();*/


                String val=String.valueOf(itemPosition);
                if(val.equals("0")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2ipjNde"));
                    startActivity(intent);
                }else if(val.equals("1")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2ipoxzz"));
                    startActivity(intent);
                }else if(val.equals("2")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2ipjZsR"));
                    startActivity(intent);
                }else if(val.equals("3")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2ipnD68"));
                    startActivity(intent);
                }else if(val.equals("4")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2ipsXGB"));
                    startActivity(intent);
                }else if(val.equals("5")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3066588/"));
                    startActivity(intent);
                }else if(val.equals("6")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2iprArk"));
                    startActivity(intent);
                }else if(val.equals("7")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2iGVwNe"));
                    startActivity(intent);
                }else if(val.equals("8")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2i1H5CV"));
                    startActivity(intent);
                }else if(val.equals("9")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.ncbi.nlm.nih.gov/books/NBK10527/"));
                    startActivity(intent);
                }else if(val.equals("10")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2iGTFbt"));
                    startActivity(intent);
                }
            }

        });




        // Clinical Pharmacology List view
        listView1 = (ListView) findViewById(R.id.listview2);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] ClinicalPharmacology= new String[] {
                "1. Clinical Trials – A Practical Guide to Design, Analysis, and Reporting",
                "2. Davis’s Pocket Clinical Drug Reference",
                "3.Handbook for good clinical research practice (gcp)",
                "4.New Drug Approval Process (Password: newDAP)",
                "5. Clinical Methods- The History , Physical & Laboratory Examination",
                "6. Advances in Patient Safety: From Research to Implementation (Volume 2: Concepts and Methodology)",
                "7. Clinical : Question & Answer",
                "8. Introduction to Clinical Pharmacology",
                "9. Concept in Clinical Pharmacokinetics",
                "10. Drug Benefit & Risk: An International Text Book of Clinical Pharmacology",
        };



        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,ClinicalPharmacology);


        // Assign adapter to ListView
        listView1.setAdapter(adapter1);

        // ListView Item Click Listener
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView1.getItemAtPosition(position);

                // Show Alert
                //     Toast.makeText(getApplicationContext(),
                //           "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                //         .show();

                String val=String.valueOf(itemPosition);
                if(val.equals("0")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2hJnv27"));
                    startActivity(intent);
                }else if(val.equals("1")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2ipt04X"));
                    startActivity(intent);
                }else if(val.equals("2")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.google.co.in/search?q=Handbook+for+good+clinical+research+practice+(gcp)"));
                    startActivity(intent);
                }else if(val.equals("3")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.google.co.in/search?q=New+Drug+Approval+Process"));
                    startActivity(intent);
                }else if(val.equals("4")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.ncbi.nlm.nih.gov/pubmed/21250045"));
                    startActivity(intent);
                }else if(val.equals("5")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.ncbi.nlm.nih.gov/books/NBK20499/"));
                    startActivity(intent);
                }else if(val.equals("6")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://www.google.co.in/search?q=Clinical+%3A+Question+%26+Answer"));
                    startActivity(intent);
                }else if(val.equals("7")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2iuJWVM"));
                    startActivity(intent);
                }else if(val.equals("8")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2iGV95s"));
                    startActivity(intent);
                }else if(val.equals("9")){
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://amzn.to/2hJv7Sa"));
                    startActivity(intent);
                }
            }

        });

        //http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords=xxxxxxxxxxx&?tag=pharstud-21

        // Pharmaceutics List view
        listView2 = (ListView) findViewById(R.id.listview3);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] Pharmaceutics= new String[] {
                "1. Modern Pharmaceutics by banker Rhodes",
                "2. Physical Pharmacy",
                "3. Pharmaceutics: The Science of Dosage Form Design by Aulton",
                "4. Handbook of Cosmetic Science and Technology, Third Edition",
                "5. Martindale : The Complete Drug Reference: 36 th Ad.",
                "6. Pharmaceutical Excipients",
                "7. Physiochemical Principle of pharmacy",
                "8. Developing Solid oral Dosage form: Pharmaceutical Theory & Practice",

        };



        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,Pharmaceutics);


        // Assign adapter to ListView
        listView2.setAdapter(adapter2);

        // ListView Item Click Listener
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView2.getItemAtPosition(position);

                // Show Alert
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords="+itemValue+"&tag=pharstud-21"));
                startActivity(intent);


            }

        });



        // PHARMACEUTICAL JURISPRUDENCE List view
        listView3 = (ListView) findViewById(R.id.listview4);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] PJ= new String[] {
                "1. Patent Act",
                "2. Pharmacy Act",
                "3. Drug and Cosmetic act",
                "4. Pharmacy practice by Tylor",

        };



        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,PJ);


        // Assign adapter to ListView
        listView3.setAdapter(adapter3);

        // ListView Item Click Listener
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView3.getItemAtPosition(position);

                // Show Alert
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords="+itemValue+"&tag=pharstud-21"));
                startActivity(intent);



            }

        });


        // PHARMACEUTICAL CHEMISTRY List view
        listView4 = (ListView) findViewById(R.id.listview5);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] PC= new String[] {
                "1. Synthesis of Essential Drugs",
                "2. Contemporary Drug Synthesis",
                "3. Essentials of Pharmaceutical Chemistry, 3rd Edition",
                "4. Wilson & Gisvold’s Textbook of Organic Medicinal and Pharmaceutical Chemistry 11th Ed.",
                "5. Foye’s Principal of Medicinal Chemistry",
                "6. Essential of Pharmaceutical Chemistry by Donald Cains",
                "7. Mark Index (14th Ad.)",
                "8. Advance Practical Medicinal Chemistry by Ashutosh Kar",
                "9. Advance Organic Chemistry: Reaction, Mechanism & Structure by Jerry March",
                "10. Organic Chemistry: Morrison & boyd",
                "11. Analytical Chemistry: by Skoog",
                "12. Principal & Practice of Pharmaceutical Medicine: Edward",
                "13. Practical Organic Chemistry: Vogel",
        };



        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,PC);


        // Assign adapter to ListView
        listView4.setAdapter(adapter4);

        // ListView Item Click Listener
        listView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView4.getItemAtPosition(position);

                // Show Alert

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords="+itemValue+"&tag=pharstud-21"));
                startActivity(intent);




            }

        });

        // BIOCHEMISTRY List view
        listView5 = (ListView) findViewById(R.id.listview6);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] BC= new String[] {
                "1. Harpers Biochemistry",
                "2. MCQs in Biochemistry",
                "3. Biochemistry: by Jermy M. Berg & Stryer",
                "4.Biochemistry: By Lehninger",
        };



        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,BC);


        // Assign adapter to ListView
        listView5.setAdapter(adapter5);

        // ListView Item Click Listener
        listView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView5.getItemAtPosition(position);

                // Show Alert

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords="+itemValue+"&tag=pharstud-21"));
                startActivity(intent);




            }

        });

// MICROBIOLOGY List view
        listView6 = (ListView) findViewById(R.id.listview7);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] MB= new String[] {
                "1. Pharmaceutical Microbiology by asutoshkar",
                "2. Microbiology by presscot",
                "3. Medical Microbiology",
                "4. Pharmaceutical Microbiology by Hugo & Russell, VI edition",
                "5. Microbiology: By Tortora",
        };



        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,MB);


        // Assign adapter to ListView
        listView6.setAdapter(adapter6);

        // ListView Item Click Listener
        listView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView6.getItemAtPosition(position);

                // Show Alert

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords="+itemValue+"&tag=pharstud-21"));
                startActivity(intent);




            }

        });

//PHARMACOGNOSY List view
        listView7 = (ListView) findViewById(R.id.listview8);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] Pcogno= new String[] {
                "1. Pharmacognosy by treese and Evans",
                "2. Illustrated Pocket Dictionary of Chromatography",
                "3. WHO guidelines for quality standards of medicinal plants",
                "4. Natural Products",
        };



        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,Pcogno);


        // Assign adapter to ListView
        listView7.setAdapter(adapter7);

        // ListView Item Click Listener
        listView7.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView7.getItemAtPosition(position);

                // Show Alert
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords="+itemValue+"&tag=pharstud-21"));
                startActivity(intent);



            }

        });


        //BIOPHARMCEUTICS List view
        listView8 = (ListView) findViewById(R.id.listview9);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] BPceutics= new String[] {
                "1. A Handbook of Bioanalysis and Drug Metabolism",
                "2. Biopharmaceutics Applications in Drug Development",
                "3. Pharmacokinetics: by Gibaldi",
                "4. Applied BioPharmaceutics:",
        };



        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,BPceutics);


        // Assign adapter to ListView
        listView8.setAdapter(adapter8);

        // ListView Item Click Listener
        listView8.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView8.getItemAtPosition(position);

                // Show Alert
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords="+itemValue+"&tag=pharstud-21"));
                startActivity(intent);




            }

        });

        //BOOKS COVER ALL SUBJECTS OF PHARMACY List view
        listView9 = (ListView) findViewById(R.id.listview10);
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] BOKPHARMA= new String[] {
                "1. Remington: The Science and Practice of Pharmacy (Remington the Science and Practice of Pharmacy)",
                "2. Comprehensive Pharmacy Review by shergel",
        };
        ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,BOKPHARMA);
        // Assign adapter to ListView
        listView9.setAdapter(adapter9);
        // ListView Item Click Listener
        listView9.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                int itemPosition     = position;
                // ListView Clicked item value
                String  itemValue    = (String) listView9.getItemAtPosition(position);

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords="+itemValue+"&tag=pharstud-21"));
                startActivity(intent);


            }
        });



        //BIOTECHNOLOGY List view
        listView10 = (ListView) findViewById(R.id.listview11);
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] BT= new String[] {
                "1. Pharmaceutical Biotechnology",

        };
        ArrayAdapter<String> adapter10 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,BT);
        // Assign adapter to ListView
        listView10.setAdapter(adapter10);
        // ListView Item Click Listener
        listView10.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                int itemPosition     = position;
                // ListView Clicked item value
                String  itemValue    = (String) listView10.getItemAtPosition(position);
                // Show Alert
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords="+itemValue+"&tag=pharstud-21"));
                startActivity(intent);

            }
        });


        //PHARMACEUTICAL ANALYSIS List view
        listView11 = (ListView) findViewById(R.id.listview12);
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] PA= new String[] {
                "1. Handbook of Pharmaceutical Analysis (Drugs and the Pharmaceutical Sciences)",
                "2. Instant Notes in Analytical Chemistry by Kealey & Haines",
                "3. Vogel’s Textbook of Quantitative Chemical Analysis, 5th edition",
                "4. Pharmaceutical Drug Analysis",
                "5. Instrumental Analysis: by Skoog",
                "6.Spectroscopy: by Silverstein"
        };
        ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,PA);
        // Assign adapter to ListView
        listView11.setAdapter(adapter11);
        // ListView Item Click Listener
        listView11.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                int itemPosition     = position;
                // ListView Clicked item value
                String  itemValue    = (String) listView11.getItemAtPosition(position);
                // Show Alert
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords="+itemValue+"&tag=pharstud-21"));
                startActivity(intent);

            }
        });


//BOOKS FOR ANATOMY & PHYSIOLOGY List view
        listView12 = (ListView) findViewById(R.id.listview13);
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        String[] BOOKPA= new String[] {
                "1. Text Book of Medical Physiology by Guyton",
                "2. Anatomy & Physiology by Ross & wilson",
        };
        ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(this,
                R.layout.country_list, R.id.textView,BOOKPA);
        // Assign adapter to ListView
        listView12.setAdapter(adapter12);
        // ListView Item Click Listener
        listView12.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // ListView Clicked item index
                int itemPosition     = position;
                // ListView Clicked item value
                String  itemValue    = (String) listView12.getItemAtPosition(position);
                // Show Alert
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amazon.in/s/ref=nb_sb_noss?url=search-alias%3Dstripbooks&field-keywords="+itemValue+"&tag=pharstud-21"));
                startActivity(intent);


            }
        });

    }

    public boolean installed = false;

    public void AdLoad(){

        String APPID=getString(R.string.MY_APP_ID);

        MobileAds.initialize(getApplicationContext(), APPID);

        AdView mAdView = (AdView) findViewById(R.id.adView);


        isAppInstalled("devesh.ephrine.gpat.pro");

        if(installed==true){
            mAdView.setVisibility(View.GONE);
            Log.e("GPAT"," AD Disabled");

        }else {

            Bundle extras = new FacebookAdapter.FacebookExtrasBundleBuilder()
                    .setNativeAdChoicesIconExpandable(false)
                    .build();

            AdRequest adRequest = new AdRequest.Builder()
                    .addNetworkExtrasBundle(FacebookAdapter.class, extras)
                    .build();
            //AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            Log.e("GPAT"," AD Loaded");

        }


    }


    private boolean isAppInstalled(String uri) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            installed = false;
        }
        return installed;
    }




}
