package org.jboss.spring.quickstarts.greeter.greeter_spring.domain;

import java.util.HashSet;
import java.util.List;


public class Itemset{
	//private int size=0;
	private HashSet<String> items= new HashSet<String>();
	
//	public Itemset(int size){
//		this.size=size;
//	}
	public Itemset(List<String> items){
		this.items=new HashSet<String>(items);
	}

	public void addItem(String item){
		this.items.add(item);
	}

	public boolean equals(Itemset otherItemset){
		boolean equal=false;

		if(this.items.size()!=otherItemset.items.size()){
			return equal;
		}
		else{
			
			HashSet<String> items = new HashSet<String> (this.items);
			items.removeAll(otherItemset.getItems());
			if(items.size()==0){
				equal=true;
			}
		}
		return equal;
	}
	
	public HashSet<String> getDifferences(Itemset otherItemset){
		HashSet<String> differences = new HashSet<String>();
		HashSet<String> curItems = new HashSet<String> (this.items);
		HashSet<String> otherItems = new HashSet<String> (otherItemset.getItems());

		curItems.removeAll(otherItemset.getItems());
		otherItems.removeAll(this.items);
		differences.addAll(curItems);
		differences.addAll(otherItems);

		// for(String item:modelItems){
		// 	differences.add(item);
		// }
		// for(String item:userItems){
		// 	differences.add(item);
		// }

		//System.out.println(differences);

		return differences;
	}

	public HashSet<String> getItems(){
		return this.items;
	}

}