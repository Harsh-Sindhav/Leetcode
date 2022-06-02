            }
            return true;
        }
        return false;
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges,(a,b) -> Integer.compare(b[0],a[0]));
        int[] parenta = new int[n+1];
        int[] parentb = new int[n+1];
        int[] ranka = new int[n+1];
        int[] rankb = new int[n+1];
        for(int i = 0;i<n+1;i++){
            parenta[i] = i;
            parentb[i] = i;
            ranka[i] = 1;
            rankb[i] = 1;
        }
        
        int remove = 0;
        int mergeda = 1;
        int mergedb = 1;
        
        for(int[] edge : edges){
            if(edge[0] == 3){
               boolean tempa = union(edge[1],edge[2],parenta,ranka);
               boolean tempb = union(edge[1],edge[2],parentb,rankb);
               if(tempa) mergeda++;
               if(tempb) mergedb++;
               if(!tempa && !tempb) remove++;
                
            }else if(edge[0] == 2){
                boolean tempb = union(edge[1],edge[2],parentb,rankb);
                if(tempb) mergedb++;
                else remove++;
            }else{
                 boolean tempa = union(edge[1],edge[2],parenta,ranka);
                if(tempa) mergeda++;
                else remove++; 
            }
        }
        
        if(mergeda != n || mergedb != n) return -1;
        return remove;
        
    }
}
