#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct node node;
struct node
{
    char *data;
    node *left;
    node *right;
};


node *newnode(char *data)
{
    //printf("%s\n",data);
    node *n = malloc(sizeof(node));
    n->data=(char *)malloc(strlen(data)+1);
   strcpy(n->data ,data);
  // printf("%s",n->data);
    n->left = n->right=NULL;
    return n;
}


node *insertnode(node *n, char *key)
{
    if (n == NULL)
        return newnode(key);
    
    if (strcasecmp(key,n->data)<0)
        n->left = insertnode(n->left, key);
    else if (strcasecmp(key,n->data)>0)
        n->right = insertnode(n->right, key);

    return n;
}



node * search_node(node *n, char * key)
{
    //if(!n->left&&!n->right)
//return n;
if(n==NULL)
    return n;
        if(strcasecmp(key,n->data)==0)
        return n;
        else if(strcasecmp(key,n->data)<0)
        {
            if(n->left==NULL)
            return n;
        return search_node(n->left,key);
        }
        else
        {
            if(n->right==NULL)
            return n;
        return search_node(n->right,key);
        }
}






node * read(node *n)
{
    //printf("##");
    char *word;
    FILE *fp;
     //printf("$$##");
    fp=fopen("D:\\tree\\EN-US-Dictionary.txt","r");
    if(fp==NULL){
    printf("Error while openning file\n");
    exit(1);}
    //printf("$$");
  
    while(!feof(fp))
    {
        fscanf(fp,"%s",word);
        n=insertnode(n,word);

    }
    fclose(fp);
    printf("Dictionary Loaded Succesfully...!\n");
      return n;
}



void inorder(node *n)
{

    if (n != NULL)
    {
        inorder(n->left);
        printf("%s ", n->data);
        inorder(n->right);
    }
}



int size(node *n)
{
    if(n==NULL)
    return 0;
    else
    return 1+size(n->right)+size(n->left);
}



int max(int a,int b)
{
    return a>b?a:b;
}
int hight(node *n)
{
    if(n==NULL)
    return -1;
    else
    return 1+max(hight(n->left),hight(n->right));
}


node* findmin(node* n)
{
    if(n==NULL)
    return NULL ;
    else if(n->left!=NULL)
    return  findmin(n->left);
    else
    {
    return n;
    }

    
}





node* findmax(node* n)
{
    if(n==NULL)
    return NULL ;
    else if(n->right!=NULL)
    return findmax(n->right);
    else
    return n;
}




        node *inorderSuccessor(node *root, char * key){ 
                if (!root) return NULL;
                node *successor = NULL;
                node *current  = root;
               
                while(current && (strcasecmp( current->data,key)!=0)){
                    if( strcasecmp( current->data , key)>0){   
                        successor = current;
                        current= current->left;
                    }
                    else current = current->right;
                }
                if (!current) return NULL;
                if(current && current->right)  
                    successor = findmin(current->right);
                return successor;                      
            }



             node *inorderpredccessor(node *root, char * key){ 
                if (!root) return NULL;
                node *successor = NULL;
                node *current  = root;
                
                while(current && (strcasecmp( current->data,key)!=0)){
                    if( strcasecmp( current->data , key)<0){
                        successor = current;
                        current= current->right;
                    }
                    else current = current->left;
                }
                if (!current) return NULL;
                if(current && current->left) 
                    successor = findmax(current->left);
                return successor;                      
            }
void check(char *token,node *n)
{
   
   printf("\n%s\n",token);
    node* gg=search_node(n,token);  
    
    
    if(strcasecmp(token,gg->data)==0){
    
    printf("\nThe word %s is correct\n ",token);
  
    }
    else
    {
        
        printf("The word %s is wrong\n",token);
       // printf("did you mean \n");
       
     
 node *temp=inorderSuccessor(n,gg->data);
        node *dess=inorderpredccessor(n,gg->data);
        printf("%s- Incorrect, Suggestions : %s   %s  %s",token,gg->data,temp->data,dess->data);
          

    }
}







int main()
{
  node *n=  NULL;
    n=read(n);
   //inorder(n);         //ptinf file
    printf("\n...........................\n");
    int s=size(n);
    printf("Size = %d\n",s);
    printf("...........................\n");
    int level=hight(n);
    printf("Hight = %d\n",level);
     printf("...........................\n");

  
     char sentence[100];
     printf("\nEnter your sentence \n\n");
     gets(sentence);
    
     
     char *token;
     token=strtok(sentence," ");
     
     while(token!=NULL)
     {
         
       
         check(token,n);
       
         token=strtok(NULL," ");
     }
    
     
    
    return 0;
}