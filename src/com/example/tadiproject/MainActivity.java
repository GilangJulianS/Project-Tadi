package com.example.tadiproject;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.tadi.fragment.DonateListFragment;
import com.tadi.fragment.FirstLoginFragment;
import com.tadi.fragment.ProfileFragment;
import com.tadi.fragment.TellUsFragment;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks, TabListener {

	public static boolean loggedIn;
	public static List<DonateItem> organizationItems = new ArrayList<>();
	public static List<DonateItem> personalItems = new ArrayList<>();
	private NavigationDrawerFragment mNavigationDrawerFragment;
	private ActionBar actionBar;
	private boolean hooh;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		organizationItems.add(new DonateItem("Panti Asuhan Bersinar", "Berdirinya Panti asuhan Bersinar berawal dari wujud kepedulian Pendiri atas dampak sosial yang terjadi di Indonesia setelah Krisis moneter pada tahun 1998.\nSebagaimana kita ketahui masalah-masalah sosial di negeri kita hingga saat ini masih menjadi PR besar bagi Negara ini..sebagai contoh meningkatnya jumlah anak putus sekolah dan tingkat pengangguran yang masih cukup tinggi hingga saat ini belum juga terselesaikan.\nDiperlukan suatu ”tindakan” untuk merubah nasib bangsa ini yaitu dengan membantu memberikan wadah bagi anak-anak terlantar dan kurang mampu untuk mempersiapkan masa depan yang lebih baik hingga pada 1 Juli 2003 didirikan \"Panti Asuhan Anak Bersinar\"", R.drawable.panti0));
		organizationItems.add(new DonateItem("Panti Asuhan Yatim Nur Hidayah", "Panti Asuhan Yayasan Nur Hidayah adalah salah satu unit dibidang sosial Yayasan Nur Hidayah Surakarta. Panti Asuhan pertama diresmikan pada tanggal 17 Juli 1997. \nProgram menyantuni dan mengasuh di asrama yatim diperuntukan bagi anak yatim yang berusia 5 tahun (TK) hingga berusia 19 tahun (lulus SMA), namun jika anak asuh mampu untuk menembus Ujian Masuk Perguruan Tinggi Negeri, yayasan akan berusaha mencarikan sponsor bagi kuliah mereka.\nAsrama yatim Nur Hidayah merupakan jembatan tali asih, asah dan asuh dari para dermawan, hartawan yang ingin menyantuni mereka, namun terhambat karena faktor kesibukan, tempat tinggal dan lain-lain.", R.drawable.panti1));
		organizationItems.add(new DonateItem("Rumah Yatim Indonesia", "Rumah Yatim Indonesia menfasilitasi para Yatim dan Dhu’afa mendapatkan haknya agar dapat mengenyam hidup dan pendidikan yang layak ditempat mereka terdampar saat ini\nRumah Yatim Indonesia siap bersinergi kepada semua Pihak baik secara kelembagaan maupun personal yang ingin memberikan kontribusi dan solusi riil dalam memberdayakan Para Yatim dan Dhu’afa\nBerharap dari sini akan lahir manusia-manusia sholeh yang siap membantu ummat dan menduplikasi sistem pendidikan dan pembinaan yang solutif ini keseluruh Nusantara khususnya untuk para Yatim dan Dhuafa.", R.drawable.panti2));
		organizationItems.add(new DonateItem("SLB Tunarungu Cicendo", "SLB Negeri Cicendo sebagai sekolah unggulan, diharapkan sekolah memiliki sarana dan prasarana yang memadai dan bias menghasilkan peserta didik yang berkompeten dalam berkomunikasi, memiliki kecakapan hidup, keterampilan dan selalu menjunjung tinggi budaya dan karakter bangsa, sehingga pasca lulus dari SMLB ini mampu bersaing hidup di tengah masyarakat dengan memanfaatkan keterampilan yang dimilikinya.", R.drawable.panti3));
		organizationItems.add(new DonateItem("Yayasan Batik Indonesia", "Yayasan Batik Indonesia yang didirikan pada tanggal 28 Oktober 1994 adalah suatu Yayasan yang dibentuk sebagai lembaga nirlaba yang merupakan wujud dari persamaan kehendak para pecinta, pengrajin, pengusaha dan pemerhati batik serta dijiwai oleh semangat Sumpah Pemuda juga merupakan mitra kerja Pemerintah dalam mengembangkan, melestarikan dan membina pengusaha/pengrajin batik nasional", R.drawable.panti4));
		organizationItems.add(new DonateItem("Yayasan Kanker Indonesia", "Yayasan Kanker Indonesia (YKI) adalah organisasi nirlaba yang bersifat sosial dan kemanusiaan di bidang kesehatan, khususnya dalam upaya penanggulangan kanker.\nTujuan YKI adalah mengupayakan penanggulangan kanker dengan menyelenggarakan kegiatan di bidang promotif, preventif dan suportif.", R.drawable.panti5));
		organizationItems.add(new DonateItem("Yayasan Keanekaragaman Hayati Indonesia", "Kehadiran Yayasan Keanekaragaman Hayati Indonesia (KEHATI) sejak 12 Januari 1994 dimaksudkan untuk menghimpun dan mengelola sumberdaya yang selanjutnya disalurkan dalam bentuk dana hibah, fasilitasi, konsultasi dan berbagai fasilitas lain guna menunjang berbagai program pelestarian keanekaragaman hayati Indonesia dan pemanfaatannya secara adil dan berkelanjutan.", R.drawable.panti6));
		organizationItems.add(new DonateItem("Yayasan Lupus Indonesia", "YLI ingin “memasyarakatkan tentang penyakit Lupus” dalam artian bukan memasyarakatkan penyakitnya, tetapi memasyarakatkan pengetahuan dan informasi tentang penyakit Lupus ini.\nkami harap masyarakat atau Odapus (Orang dengan Lupus) untuk mengenal lebih jauh tentang penyakit Lupus untuk penanganan lebih dini sehingga tidak terjadi keparahan sebagaimana yang kerap terjadi – Odapus memeriksakan dirinya, terlambat.", R.drawable.panti7));
		organizationItems.add(new DonateItem("Yayasan Sosial Indonesia Kemanusiaan", "Setelah 15 tahun berdiri dan dulunya fokus kepada penggiat kemanusiaan saat pemerintahan orde baru, kini YSIK memantapkan posisinya sebagai organisasi sumberdaya yang menghimpun, mengelola dan menyalurkan dana, jejaring dan kerelawanan bagi perjuangan warga sebagai bagian dari kekuatan gerakan masyarakat sipil untuk memperjuangkan kehidupan yang sejahtera, adil dan bermartabat bagi semua orang dalam kerangka hak-hak asasi manusia dan pemeliharaan linkungan yang berkelanjutan.", R.drawable.panti8));
		organizationItems.add(new DonateItem("Yayasan Usaha Mulia", "Dengan membawa motto \"meningkatkan kualitas hidup masyarakat miskin Indonesia\", sejak tahun 1960 Yayasan Usaha Mulia memfokuskan kegiatan mereka pada bidang kesehatan, pendidikan dan community development. Pada awal 1990, YUM sudah memberikan service hingga 50.000 lebih masyarakat Indonesia tiap tahunnya dan terus berkembang hingga sekarang.", R.drawable.panti9));
		
		personalItems.add(new DonateItem("Nia, 8, Demam Berdarah", "Sekitar 1 minggu lalu, suhu tubuh Nia naik hingga 39 derajat Celcius. Ia harus menunggu sekitar 4 masuk hingga akhirnya dimasukkan ke bangsal perawatan karena tidak adanya biaya pengobatan.", R.drawable.orang0));
		personalItems.add(new DonateItem("Rigan, 2, Demam dan Sesak Nafas", "Rigan telah mengalami deman dan sesak nafas sejak 4 hari lalu dan kondisinya belum juga membaik. ", R.drawable.orang1));
		personalItems.add(new DonateItem("Adi, 12, Kurang Gizi", "Adi dirawat di RS Hasan Sadikin sejak 12 November karena kekurangan gizi dan kondisinya semakin memburuk.", R.drawable.orang2));
		personalItems.add(new DonateItem("Rani, 9, Tumor Otak", "Sejak 2 bulan lalu, Rani telah dirawat di RS Dr Sariadi karena penyakit tumor otak yang semakin memburuk. Kedua orangtuanya kesulitan untuk mendapatkan pembiayaan karena ayahnya hanya seorang buruh bangunan.", R.drawable.orang3));
		
		
		actionBar = getSupportActionBar();
		actionBar.addTab(actionBar.newTab().setText("Organizational").setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Personal").setTabListener(this));
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
				.findFragmentById(R.id.navigation_drawer);

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));	
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getSupportFragmentManager();
		if(position == 0 && !loggedIn)
			fragmentManager.beginTransaction()
					.replace(R.id.container, new FirstLoginFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
		else if(position == 0 && loggedIn)
			fragmentManager.beginTransaction()
					.replace(R.id.container, new ProfileFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
		else if(position == 1)
			fragmentManager.beginTransaction()
				.replace(R.id.container, new DonateListFragment(true)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
		else if(position == 3){
			fragmentManager.beginTransaction()
				.replace(R.id.container, new TellUsFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
		}
		else if(position == 4){
			loggedIn = false;
			fragmentManager.beginTransaction()
				.replace(R.id.container, new DonateListFragment(true)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
			mNavigationDrawerFragment.getAdapter().notifyDataSetChanged();
		}
		
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public NavigationDrawerFragment getDrawer(){
		return mNavigationDrawerFragment;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		if(hooh){
			if(tab.getPosition() == 0)
				getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, new DonateListFragment(true)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
			else
				getSupportFragmentManager().beginTransaction()
					.replace(R.id.container, new DonateListFragment(false)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
		}
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void changeMode(boolean tabMode){
		hooh = false;
		if(tabMode)
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		else
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		hooh = true;
	}


}
