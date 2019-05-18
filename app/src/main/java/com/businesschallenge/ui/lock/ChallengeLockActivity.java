package com.businesschallenge.ui.lock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import com.businesschallenge.Constants;
import com.businesschallenge.DataProccessor;
import com.businesschallenge.R;
import com.businesschallenge.ui.ChallengeDetailActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ChallengeLockActivity extends AppCompatActivity {

    private BusinessAdapter businessAdapter;
    private BusinessListViewModel mViewModel;
    @BindView(R.id.relative_layout)
    RelativeLayout relativeLayout;
    private Snackbar mSnackbar;
    SharedPreferences sharedPrefs;
    long diffMillis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_challenge);
        ButterKnife.bind(this);

        sharedPrefs = getSharedPreferences(Constants.PREFS, MODE_PRIVATE);

        mViewModel = obtainViewModel(this);
        setupListAdapter();
        DataProccessor dataProccessor = new DataProccessor(this);

        Calendar cal = Calendar.getInstance();
        cal.clear(Calendar.HOUR);
        cal.clear(Calendar.HOUR_OF_DAY);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        // Get time in Millis
        final long saveMillis = cal.getTimeInMillis();
        final long now = cal.getTimeInMillis();

        // subscribe to business observable livedata
        mViewModel.getBusinessList().observe(this, sandwiches -> {
            if (sandwiches != null) {
                businessAdapter.replaceData(sandwiches);
            }
        });

        // Subscribe to "open business" event
        mViewModel.getOpenBusinessEvent().observe(this, position -> {
            if (position != null) {

                if (position == 0) {
                    dataProccessor.setBool(Constants.DAY_ONE, true);
                    int one = dataProccessor.getInt("one");

                    if (one > 0) {
                        Log.d("ChallengeLockActivity", "Nothing to save");
                    } else if (one == 0) {
                        SharedPreferences.Editor editor = sharedPrefs.edit();
                        editor.putLong(Constants.D_1, saveMillis);
                        editor.apply();
                        one++;
                        dataProccessor.setInt("one", one);
                    }

                    launchDetailActivity(position);

                }
                if (position == 1) {
                    long day2 = sharedPrefs.getLong(Constants.D_1, 0);
                    diffMillis = now - day2;
                    if (dataProccessor.getBool(Constants.DAY_ONE) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_TWO, true);
                        int two = dataProccessor.getInt("two");


                        if (two > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (two == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_2, saveMillis);
                            editor.apply();
                            two++;
                            dataProccessor.setInt("two", two);
                        }

                        launchDetailActivity(position);

                    } else {

                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 2) {
                    long day3 = sharedPrefs.getLong(Constants.D_2, 0);
                    diffMillis = now - day3;
                    if (dataProccessor.getBool(Constants.DAY_TWO) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_THREE, true);
                        int three = dataProccessor.getInt("three");


                        if (three > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (three == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_3, saveMillis);
                            editor.apply();
                            three++;
                            dataProccessor.setInt("three", three);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 3) {
                    // check if date is passed 24hours from previous item clicked
                    long day4 = sharedPrefs.getLong(Constants.D_3, 0);
                    diffMillis = now - day4;
                    if (dataProccessor.getBool(Constants.DAY_THREE) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_FOUR, true);
                        int four = dataProccessor.getInt("four");

                        if (four > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (four == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_4, saveMillis);
                            editor.apply();
                            four++;
                            dataProccessor.setInt("four", four);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 4) {
                    // check if date is passed 24hours from previous item clicked
                    long day5 = sharedPrefs.getLong(Constants.D_4, 0);
                    diffMillis = now - day5;
                    if (dataProccessor.getBool(Constants.DAY_FOUR) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_FIVE, true);
                        int five = dataProccessor.getInt("five");

                        if (five > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (five == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_5, saveMillis);
                            editor.apply();
                            five++;
                            dataProccessor.setInt("five", five);
                        }
                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 5) {
                    // check if date is passed 24hours from previous item clicked
                    long day6 = sharedPrefs.getLong(Constants.D_5, 0);
                    diffMillis = now - day6;
                    if (dataProccessor.getBool(Constants.DAY_FIVE) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_SIX, true);
                        int six = dataProccessor.getInt("six");


                        if (six > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (six == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_6, saveMillis);
                            editor.apply();
                            six++;
                            dataProccessor.setInt("six", six);
                        }
                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 6) {
                    // check if date is passed 24hours from previous item clicked
                    long day7 = sharedPrefs.getLong(Constants.D_6, 0);
                    diffMillis = now - day7;
                    if (dataProccessor.getBool(Constants.DAY_SIX) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_SEVEN, true);
                        int seven = dataProccessor.getInt("seven");


                        if (seven > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (seven == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_7, saveMillis);
                            editor.apply();
                            seven++;
                            dataProccessor.setInt("seven", seven);
                        }
                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 7) {
                    // check if date is passed 24hours from previous item clicked
                    long day8 = sharedPrefs.getLong(Constants.D_7, 0);
                    diffMillis = now - day8;
                    if (dataProccessor.getBool(Constants.DAY_SEVEN) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_EIGHT, true);
                        int eight = dataProccessor.getInt("eight");


                        if (eight > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (eight == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_8, saveMillis);
                            editor.apply();
                            eight++;
                            dataProccessor.setInt("eight", eight);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 8) {
                    // check if date is passed 24hours from previous item clicked
                    long day9 = sharedPrefs.getLong(Constants.D_8, 0);
                    diffMillis = now - day9;
                    if (dataProccessor.getBool(Constants.DAY_EIGHT) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_NINE, true);
                        int nine = dataProccessor.getInt("nine");


                        if (nine > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (nine == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_9, saveMillis);
                            editor.apply();
                            nine++;
                            dataProccessor.setInt("nine", nine);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 9) {
                    // check if date is passed 24hours from previous item clicked
                    long day10 = sharedPrefs.getLong(Constants.D_9, 0);
                    diffMillis = now - day10;
                    if (dataProccessor.getBool(Constants.DAY_NINE) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_TEN, true);
                        int ten = dataProccessor.getInt("ten");


                        if (ten > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (ten == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_10, saveMillis);
                            editor.apply();
                            ten++;
                            dataProccessor.setInt("ten", ten);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 10) {
                    // check if date is passed 24hours from previous item clicked
                    long day11 = sharedPrefs.getLong(Constants.D_10, 0);
                    diffMillis = now - day11;
                    if (dataProccessor.getBool(Constants.DAY_TEN) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_ELEVEN, true);
                        int eleven = dataProccessor.getInt("eleven");


                        if (eleven > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (eleven == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_11, saveMillis);
                            editor.apply();
                            eleven++;
                            dataProccessor.setInt("eleven", eleven);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 11) {
                    // check if date is passed 24hours from previous item clicked
                    long day12 = sharedPrefs.getLong(Constants.D_11, 0);
                    diffMillis = now - day12;
                    if (dataProccessor.getBool(Constants.DAY_ELEVEN) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_TWELVE, true);
                        int twelve = dataProccessor.getInt("twelve");


                        if (twelve > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (twelve == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_12, saveMillis);
                            editor.apply();
                            twelve++;
                            dataProccessor.setInt("twelve", twelve);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 12) {
                    // check if date is passed 24hours from previous item clicked
                    long day13 = sharedPrefs.getLong(Constants.D_12, 0);
                    diffMillis = now - day13;
                    if (dataProccessor.getBool(Constants.DAY_TWELVE) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_THIRTEEN, true);
                        int thirteen = dataProccessor.getInt("thirteen");


                        if (thirteen > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (thirteen == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_13, saveMillis);
                            editor.apply();
                            thirteen++;
                            dataProccessor.setInt("thirteen", thirteen);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 13) {
                    // check if date is passed 24hours from previous item clicked
                    long day14 = sharedPrefs.getLong(Constants.D_13, 0);
                    diffMillis = now - day14;
                    if (dataProccessor.getBool(Constants.DAY_THIRTEEN) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_FOURTEEN, true);
                        int fourteen = dataProccessor.getInt("fourteen");


                        if (fourteen > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (fourteen == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_14, saveMillis);
                            editor.apply();
                            fourteen++;
                            dataProccessor.setInt("fourteen", fourteen);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 14) {
                    // check if date is passed 24hours from previous item clicked
                    long day15 = sharedPrefs.getLong(Constants.D_14, 0);
                    diffMillis = now - day15;

                    if (dataProccessor.getBool(Constants.DAY_FOURTEEN) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_FIFTEEN, true);
                        int fifteen = dataProccessor.getInt("fifteen");


                        if (fifteen > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (fifteen == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_15, saveMillis);
                            editor.apply();
                            fifteen++;
                            dataProccessor.setInt("fifteen", fifteen);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 15) {
                    // check if date is passed 24hours from previous item clicked
                    long day16 = sharedPrefs.getLong(Constants.D_15, 0);
                    diffMillis = now - day16;
                    if (dataProccessor.getBool(Constants.DAY_FIFTEEN) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_SIXTEEN, true);
                        int sixteen = dataProccessor.getInt("sixteen");


                        if (sixteen > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (sixteen == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_16, saveMillis);
                            editor.apply();
                            sixteen++;
                            dataProccessor.setInt("sixteen", sixteen);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 16) {
                    // check if date is passed 24hours from previous item clicked
                    long day17 = sharedPrefs.getLong(Constants.D_16, 0);
                    diffMillis = now - day17;
                    if (dataProccessor.getBool(Constants.DAY_SIXTEEN) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_SEVENTEEN, true);
                        int seventeen = dataProccessor.getInt("seventeen");


                        if (seventeen > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (seventeen == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_17, saveMillis);
                            editor.apply();
                            seventeen++;
                            dataProccessor.setInt("seventeen", seventeen);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 17) {
                    // check if date is passed 24hours from previous item clicked
                    long day18 = sharedPrefs.getLong(Constants.D_17, 0);
                    diffMillis = now - day18;
                    if (dataProccessor.getBool(Constants.DAY_SEVENTEEN) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_EIGHTEEN, true);
                        int eighteen = dataProccessor.getInt("eighteen");


                        if (eighteen > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (eighteen == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_18, saveMillis);
                            editor.apply();
                            eighteen++;
                            dataProccessor.setInt("eighteen", eighteen);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 18) {
                    // check if date is passed 24hours from previous item clicked
                    long day19 = sharedPrefs.getLong(Constants.D_18, 0);
                    diffMillis = now - day19;
                    if (dataProccessor.getBool(Constants.DAY_EIGHTEEN) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_NINETEEN, true);
                        int nineteen = dataProccessor.getInt("nineteen");

                        if (nineteen > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (nineteen == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_19, saveMillis);
                            editor.apply();
                            nineteen++;
                            dataProccessor.setInt("nineteen", nineteen);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 19) {
                    // check if date is passed 24hours from previous item clicked
                    long day20 = sharedPrefs.getLong(Constants.D_19, 0);
                    diffMillis = now - day20;
                    if (dataProccessor.getBool(Constants.DAY_NINETEEN) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_TWENTY, true);
                        int twenty = dataProccessor.getInt("twenty");


                        if (twenty > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (twenty == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_20, saveMillis);
                            editor.apply();
                            twenty++;
                            dataProccessor.setInt("twenty", twenty);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 20) {
                    // check if date is passed 24hours from previous item clicked
                    long day21 = sharedPrefs.getLong(Constants.D_20, 0);
                    diffMillis = now - day21;
                    if (dataProccessor.getBool(Constants.DAY_TWENTY) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_21, true);
                        int twentyOne = dataProccessor.getInt("twentyOne");


                        if (twentyOne > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (twentyOne == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_21, saveMillis);
                            editor.apply();
                            twentyOne++;
                            dataProccessor.setInt("twentyOne", twentyOne);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 21) {
                    // check if date is passed 24hours from previous item clicked
                    long day22 = sharedPrefs.getLong(Constants.D_21, 0);
                    diffMillis = now - day22;

                    if (dataProccessor.getBool(Constants.DAY_21) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_22, true);
                        int twentyTwo = dataProccessor.getInt("twentyTwo");


                        if (twentyTwo > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (twentyTwo == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_22, saveMillis);
                            editor.apply();
                            twentyTwo++;
                            dataProccessor.setInt("twentyTwo", twentyTwo);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 22) {
                    // check if date is passed 24hours from previous item clicked
                    long day23 = sharedPrefs.getLong(Constants.D_22, 0);
                    diffMillis = now - day23;
                    if (dataProccessor.getBool(Constants.DAY_22) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_23, true);
                        int twentyThree = dataProccessor.getInt("twentyThree");


                        if (twentyThree > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (twentyThree == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_23, saveMillis);
                            editor.apply();
                            twentyThree++;
                            dataProccessor.setInt("twentyThree", twentyThree);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 23) {
                    // check if date is passed 24hours from previous item clicked
                    long day24 = sharedPrefs.getLong(Constants.D_23, 0);
                    diffMillis = now - day24;
                    if (dataProccessor.getBool(Constants.DAY_23) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_24, true);
                        int twentyFour = dataProccessor.getInt("twentyFour");


                        if (twentyFour > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (twentyFour == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_24, saveMillis);
                            editor.apply();
                            twentyFour++;
                            dataProccessor.setInt("twentyFour", twentyFour);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 24) {
                    // check if date is passed 24hours from previous item clicked
                    long day25 = sharedPrefs.getLong(Constants.D_24, 0);
                    diffMillis = now - day25;
                    if (dataProccessor.getBool(Constants.DAY_24) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_25, true);
                        int twentyFive = dataProccessor.getInt("twentyFive");

                        if (twentyFive > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (twentyFive == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_25, saveMillis);
                            editor.apply();
                            twentyFive++;
                            dataProccessor.setInt("twentyFive", twentyFive);
                        }
                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 25) {
                    // check if date is passed 24hours from previous item clicked
                    long day26 = sharedPrefs.getLong(Constants.D_25, 0);
                    diffMillis = now - day26;
                    if (dataProccessor.getBool(Constants.DAY_25) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_26, true);
                        int twentySix = dataProccessor.getInt("twentySix");


                        if (twentySix > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (twentySix == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_26, saveMillis);
                            editor.apply();
                            twentySix++;
                            dataProccessor.setInt("twentySix", twentySix);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 26) {
                    // check if date is passed 24hours from previous item clicked
                    long day27 = sharedPrefs.getLong(Constants.D_26, 0);
                    diffMillis = now - day27;
                    if (dataProccessor.getBool(Constants.DAY_26) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_27, true);
                        int twentySeven = dataProccessor.getInt("twentySeven");

                        if (twentySeven > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (twentySeven == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_27, saveMillis);
                            editor.apply();
                            twentySeven++;
                            dataProccessor.setInt("twentySeven", twentySeven);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 27) {
                    // check if date is passed 24hours from previous item clicked
                    long day28 = sharedPrefs.getLong(Constants.D_27, 0);
                    diffMillis = now - day28;
                    if (dataProccessor.getBool(Constants.DAY_27) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_28, true);
                        int twentyEight = dataProccessor.getInt("twentyEight");

                        if (twentyEight > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (twentyEight == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_28, saveMillis);
                            editor.apply();
                            twentyEight++;
                            dataProccessor.setInt("twentyEight", twentyEight);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 28) {
                    // check if date is passed 24hours from previous item clicked
                    long day29 = sharedPrefs.getLong(Constants.D_28, 0);
                    diffMillis = now - day29;
                    if (dataProccessor.getBool(Constants.DAY_28) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_29, true);
                        int twentyNine = dataProccessor.getInt("twentyNine");


                        if (twentyNine > 0) {
                            Log.d("ChallengeLockActivity", "Nothing to save");
                        } else if (twentyNine == 0) {
                            SharedPreferences.Editor editor = sharedPrefs.edit();
                            editor.putLong(Constants.D_29, saveMillis);
                            editor.apply();
                            twentyNine++;
                            dataProccessor.setInt("twentyNine", twentyNine);
                        }

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }
                if (position == 29) {
                    // check if date is passed 24hours from previous item clicked
                    long day30 = sharedPrefs.getLong(Constants.D_29, 0);
                    diffMillis = now - day30;
                    if (dataProccessor.getBool(Constants.DAY_29) && diffMillis >= (3600000 * 24)) {
                        dataProccessor.setBool(Constants.DAY_30, true);

                        launchDetailActivity(position);
                    } else {
                        showSnackbar(getString(R.string.unlock_previous));
                    }
                }


            }
        });

    }

    private BusinessListViewModel obtainViewModel(FragmentActivity activity) {
        return ViewModelProviders.of(activity).get(BusinessListViewModel.class);
    }

    @SuppressLint("WrongConstant")
    private void setupListAdapter() {
        RecyclerView recyclerView = findViewById(R.id.recycler_business);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        businessAdapter = new BusinessAdapter(this,
                new ArrayList<>(0),
                mViewModel
        );
        recyclerView.setAdapter(businessAdapter);
    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, ChallengeDetailActivity.class);
        intent.putExtra(ChallengeDetailActivity.EXTRA_POSITION, position);
        startActivity(intent);
    }

    private void showSnackbar(String text) {
        mSnackbar = Snackbar.make(relativeLayout, text, Snackbar.LENGTH_INDEFINITE);
        mSnackbar.setAction(R.string.action_close, view -> mSnackbar.dismiss());
        mSnackbar.show();
    }

}
