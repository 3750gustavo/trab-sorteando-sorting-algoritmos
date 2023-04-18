package source;



public class Principal {
	
	public int[] constroiLista(int tamanho) {
		int lista[] = new int[tamanho];
		for(int x=tamanho,y=0;x>0;x--,y++) {
			lista[y]=x;
		}
		return lista;
	}
	
	public void imprimeLista(long[] lista) {
		for(int x=0;x<lista.length;x++) {
			System.out.print(lista[x]+" ");
		}
		System.out.println();
	}
	
	public void imprimeLista(int[] lista) {
		for(int x=0;x<lista.length;x++) {
			System.out.print(lista[x]+" ");
		}
		System.out.println();
	}
	
	void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

	void insertionSort(int arr[]) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}


// Shell sort function that takes an int array and returns void
void shellSort(int[] arr) {
  // Find the gap size by dividing the array length by 2
  int gap = arr.length / 2;
  // Loop until the gap is 0
  while (gap > 0) {
    // Loop through the array from the gap to the end
    for (int i = gap; i < arr.length; i++) {
      // Store the current element
      int temp = arr[i];
      // Initialize a pointer to the previous element with the same gap
      int j = i - gap;
      // Loop backwards until the pointer is negative or the element is smaller than temp
      while (j >= 0 && arr[j] > temp) {
        // Shift the element to the right by the gap
        arr[j + gap] = arr[j];
        // Move the pointer to the left by the gap
        j -= gap;
      }
      // Insert temp at the correct position
      arr[j + gap] = temp;
    }
    // Reduce the gap size by half
    gap /= 2;
  }
}

	void cubeSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public long[] execute() {
		Principal programa = new Principal();
		long tempos[] = new long[1000];
		for(int x=1;x<=1000;x++) {
			int l[] = programa.constroiLista(x);		
			long ini = System.nanoTime();
			programa.bubbleSort(l);
			long fim = System.nanoTime();
			tempos[x-1]=fim-ini;
		}
		//programa.imprimeLista(tempos);
		return tempos;
	}

public long[] executeA() {
	Principal programa = new Principal();
	long tempos[] = new long[1000];
	for(int x=1;x<=1000;x++) {
		int l[] = programa.constroiLista(x);		
		long ini = System.nanoTime();
		programa.insertionSort(l);
		long fim = System.nanoTime();
		tempos[x-1]=fim-ini;
	}
	//programa.imprimeLista(tempos);
	return tempos;
}

public long[] executeB() {
	Principal programa = new Principal();
	long tempos[] = new long[1000];
	for(int x=1;x<=1000;x++) {
		int l[] = programa.constroiLista(x);		
		long ini = System.nanoTime();
		programa.cubeSort(l);
		long fim = System.nanoTime();
		tempos[x-1]=fim-ini;
	}
	//programa.imprimeLista(tempos);
	return tempos;
}

public long[] executeC() {
	Principal programa = new Principal();
	long tempos[] = new long[1000];
	for(int x=1;x<=1000;x++) {
		int l[] = programa.constroiLista(x);		
		long ini = System.nanoTime();
		programa.shellSort(l);
		long fim = System.nanoTime();
		tempos[x-1]=fim-ini;
	}
	//programa.imprimeLista(tempos);
	return tempos;
}

}

