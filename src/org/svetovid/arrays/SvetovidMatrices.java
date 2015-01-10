package org.svetovid.arrays;

import java.lang.reflect.Array;

public class SvetovidMatrices {

	public static <T> int rows(T[][] matrix) {
		if (matrix == null) {
			return 0;
		}
		return matrix.length;
	}

	public static <T> int columns(T[][] matrix) {
		if (matrix == null) {
			return 0;
		}
		int columns = 0;
		for (T[] row : matrix) {
			if ((row != null) && (row.length > columns)) {
				columns = row.length;
			}
		}
		return columns;
	}

	public static <T> T[][] empty(int size, Class<T> type) {
		@SuppressWarnings("unchecked")
		T[][] newMatrix = (T[][]) Array.newInstance(type, size, size);
		return newMatrix;
	}
	
	public static <T> T[][] empty(int size, T zero) {
		@SuppressWarnings("unchecked")
		T[][] newMatrix = (T[][]) Array.newInstance(zero.getClass(), size, size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				newMatrix[i][j] = zero;
			}
		}
		return newMatrix;
	}
	
	public static <T> T[][] identity(int size, T zero, T one) {
		T[][] newMatrix = empty(size, zero);
		for (int i = 0; i < size; i++) {
			newMatrix[i][i] = one;
		}
		return newMatrix;
	}

	public static <T> T[][] resize(T[][] matrix, int rows, int columns, T defaultValue) {
		if (rows < 0) {
			rows = rows(matrix);
		}
		if (columns < 0) {
			columns = columns(matrix);
		}
		@SuppressWarnings("unchecked")
		T[][] newMatrix = (T[][]) Array.newInstance(matrix.getClass().getComponentType().getComponentType(), rows, columns);
		int length = rows < matrix.length ? rows : matrix.length;
		for (int r = 0; r < length; r++) {
			int rowLength = columns < matrix[r].length ? columns : matrix[r].length;
			for (int c = 0; c < rowLength; c++) {
				newMatrix[r][c] = matrix[r][c];
			}
			for (int c = rowLength; c < columns; c++) {
				newMatrix[r][c] = defaultValue;
			}
		}
		for (int r = length; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				newMatrix[r][c] = defaultValue;
			}
		}
		return newMatrix;
	}

	// TODO Add methods for:
	// Copy a matrix or part of it
	// Get and set individual elements with guards for index range
	// Extract row or column as array

}
