package br.com.bollyfilmes.utils.enums;


import br.com.bollyfilmes.view.abstracts.AbstractFragment;
import br.com.bollyfilmes.view.fragments.listafilmes.FilmesFragment;
import br.com.bollyfilmes.view.fragments.splash.SSplashFragment;

/**
 * Here are all enums that will be used in the application, along with its keys and values
 * */
public enum ControlFrags {

	SPLASH	     			("splash", 		 	SSplashFragment.class),
	FILMES                  ("filme_fragment", 	FilmesFragment.class);


	private String name;
	private Class<? extends AbstractFragment> classFrag;
	
	private ControlFrags(final String name, Class<? extends AbstractFragment> classFrag) {
		this.name = name;
		this.classFrag = classFrag;
	}



	public String getName() {
		return name;
	}
	public Class<? extends AbstractFragment> getClassFrag() {
		return classFrag;
	}
}
