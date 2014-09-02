package model.drawables;

import model.Face;
import model.Vertex;

public class Curve extends DrawableObject {
	private boolean[] bits;
	private int harmonic;
	private double bps;
	private double bandwidth;

	// private double cn;
	public Curve(boolean[] bits, int bandwidth, int harmonic, int bps) {
		super();
		this.bits = bits;
		this.bandwidth = bandwidth;
		this.bps = bps;
		this.harmonic = harmonic;
	}

	public void create() {
		faces.clear();
		Face line;

		double[] next = new double[harmonic];
		double[] last = new double[harmonic];
		double[] an = new double[harmonic];
		double[] bn = new double[harmonic];
		double[] dc = new double[harmonic];
		for (int k = 0; k < harmonic; k++) {
			
			an[k] = 0;
			bn[k] = 0;
			dc[k] = 0;

			for (int i = 0; i < bits.length; i++) {
				if (bits[i]) {
					/*
					 * an[k] += ((Math.cos(2 * Math.PI * (i + 1) * (k + 1)
					 * getFrequency()) / Math.PI / (k + 1) ) - (Math.cos(2 *
					 * Math.PI * (i) (k + 1) * getFrequency()) / Math.PI / (k +
					 * 1)));
					 * 
					 * bn[k] += ((Math.sin(2 * Math.PI * (i + 1) * (k + 1)
					 * getFrequency()) / Math.PI / (k + 1)) - (Math.sin(2 *
					 * Math.PI * (i) (k + 1) * getFrequency()) / Math.PI / (k +
					 * 1)));
					 */
					dc[k]++;

					an[k] += 1
							/ (Math.PI * (k + 1))
							* (Math.cos((i + 1) * 2 * Math.PI * (k + 1)
									/ bits.length) - Math.cos(2 * (i)
									* Math.PI * (k + 1) / bits.length));

					bn[k] += 1
							/ (Math.PI * (k + 1))
							* (Math.sin(2 * (i + 1) * Math.PI * (k + 1)
									/ bits.length) - Math.sin(2 * (i)
									* Math.PI * (k + 1) / bits.length));


				}
			}

			dc[k] /= bits.length;

			last[k] = dc[k] + an[k]
					* Math.sin(2 * Math.PI * (k + 1) * getFrequency() * 8)
					+ bn[k]
					* Math.cos(2 * Math.PI * (k + 1) * getFrequency() * 8);

		}

		boolean firstRun = true;
		double firstSum = 0;
		double step = 0.001;
		double width = -5.8;
		double height = -17;
		int factor = 2;

		for (double i = step; i < 8; i += step) {
			for (int k = 0; k < harmonic; k++) {

				next[k] = dc[k] + an[k]
						* Math.sin(2 * Math.PI * (k + 1) * getFrequency() * (8-i))
						+ bn[k]
						* Math.cos(2 * Math.PI * (k + 1) * getFrequency() * (8-i));
				line = new Face(new Vertex(factor * (i- step + width),
						last[k], k  + 1 + height, 1), new Vertex(factor
						* (i + width), next[k], k + 1 + height, 1));
				faces.add(line);

			}
			double sum1 = 0, sum2 = 0;
			for (int k = 0; k < harmonic; k++) {
				sum1 += last[k];

				sum2 += next[k];
			}
			if (firstRun) {
				firstSum = sum1;
				boolean anyPositive = false;
				for (boolean b : bits) {
					if (b)
						anyPositive = true;
				}
				if (anyPositive)
					firstSum -= 1;
				firstRun = false;

			}

			line = new Face(new Vertex(factor * (i - step + width), sum1
					- firstSum, height, 1), new Vertex(factor * (i + width),
					sum2 - firstSum, height, 1));
			line.setRed(true);
			faces.add(line);
			for (int k = 0; k < harmonic; k++)
				last[k] = next[k];

		}
		/*
		 * Basis line später fixen
		 */
		/**
		 * line = new Face(new Vertex(-5, 0, 0, 1), new Vertex(bits.length - 5,
		 * 0, 0, 1)); faces.add(line);
		 */
	}

	private double getT() {
		// TODO Auto-generated method stub
		return (double) bits.length / (double) bps;
	}

	private double getFrequency() {

		return 1 / getT();
	}

	public boolean[] getBits() {
		return bits;
	}

	public void setBits(boolean[] bits) {
		this.bits = bits;
	}

	public double getBandwidth() {
		return bandwidth;
	}

	public boolean setBandwidth(int bandwidth) {

		this.bandwidth = bandwidth;
		return control();
	}

	private boolean control() {
		double c = (double) bps / (double) bits.length;
		c = bandwidth / c;
		return (harmonic < c);

	}

	public int getHarmonic() {
		return harmonic;
	}

	public void setHarmonic(int harmonic) {
		this.harmonic = harmonic;
	}

	public double getBps() {
		return bps;
	}

	public void setBps(int bps) {
		this.bps = bps;
	}
}