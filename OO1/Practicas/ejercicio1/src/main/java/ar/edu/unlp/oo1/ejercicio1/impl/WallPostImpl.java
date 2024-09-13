package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {

	// creo atributos necesarios
	String texto = "Undefined post";
	int like = 0;
	boolean featured = false;
	
	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return this.texto;
	}

	@Override
	public void setText(String text) {
		// TODO Auto-generated method stub
		this.texto = text;
	}

	@Override
	public int getLikes() {
		// TODO Auto-generated method stub
		return this.like;
	}

	@Override
	public void like() {
		// TODO Auto-generated method stub
		this.like++;
	}

	@Override
	public void dislike() {
		// TODO Auto-generated method stub
		if (this.like > 0) {
			this.like--;	
		}
	}

	@Override
	public boolean isFeatured() {
		// TODO Auto-generated method stub
		return featured;
	}

	@Override
	public void toggleFeatured() {
		// TODO Auto-generated method stub
		if (this.featured == true) {
			this.featured = false;
		} else {
			this.featured = true;
		}
	}
	
	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }

}
