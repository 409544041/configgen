# configgen

�������ɹ��ߣ�������Ϊ�Ǹ�����ֻ��object��object-relational mapping

## ��Ŀ�ſ�

* ͨ�����������ȡֵ��Χ��ʹ�߻�������ʱ�����������
* ͨ�����ɴ��룬ʹ���򷽱�������ͻ����ݣ�������ú͵���һ�У�֧��java,csharp,lua

## ���ٿ�ʼ
* example/config ����csv�������config.xml �������ļ���
  ��ʾ��ref��enum��nullableref��listref��bean��ʹ��
* example/java, cs, luaĿ¼���ļ���gen.bat���ɵĴ����ļ������ο���gen.bat���ɵ������ļ���û���ϴ��ˡ�

## ʹ������

1. �½����޸� csv�ļ���csv�ļ�ǰ2��Ϊheader����һ��������˵�����ڶ�����Ӣ���ֶ�
2. ʹ��configgen.jar �����ɻ����Ʒ������ͻ��˹�ͬʹ�õ�config.xml
3. ���Ĭ�ϵ���Ϊ����������������ֶ��޸�config.xml�������޸�type������ref��enum��range
4. �ظ�1��2��3����

## ��������

* config/bean.name
    - �ļ�·����ȫСд��·����.�ָ������package����ͳһ��ͬʱ����linux��windows����
    - bean�����Լ��ֹ���config.xml�ﶨ�壻field.type����bean��ʱ��Ҳ�����ֹ�ָ������Щû���Զ��²⡣

* config.keys
    - Ĭ�ϲ������ã��ǵ�һ��field��������������ã����ŷָ����keys="aa,bb"����2��field aa,bbΪkey
    - ���ɴ�������������ã���������Զ�resolve������������ÿ�м�¼

* config.enum
    - Ĭ�ϲ������ã����Ҫ������Ϊenum�������ã�����enum="aa"����field aa��Ϊenum����

* bean.compress
    - Ĭ����false��������bean�Ǳ��ŵ���Ԫ���Ҫ����Ϊtrue

* field.desc, name
    - configgen.jar���csv�ļ���1,2����ȡ��
    - list a1,a2: nameΪaList
    - map a1,b1,a2,b2: nameΪa2bMap
    - ���ɴ���ʱ����csv���������ƵĴ�Сд��
    - ��Ա����Ϊ����ĸСд��name����Ա����Ϊget+����ĸ��д��name
    - �����õ��������Ա����ΪRef+����ĸ��д��name�� ��Ա����Ϊref/nullableRef+����ĸ��д��name

* field.type
    - bool,int,long,float,string(text),bean
    - list,xx,count     ArrayList��count�����ڵ�ʱ�򣬵�Ԫ����list��count���ڵĻ��Ӷ���fieldname1��fieldname2�������ж�ȡ���ݡ�
    - map,xx,yy,count   LinkedHashMap; ;xx,yy��Ϊ������ʽ���Ӷ���fieldkey1��fieldvalue1��fieldkey2, fieldvalue2�������ж�ȡ���ݡ�

    - csvһ����Ԫ��,�����ǻ�������,����bean,����list�������list��Ԫ�ر����ǻ������ͣ������bean���붨��compress="true"
    - text���ڿͻ���ʵ�ֹ��ʻ�������������Ϊtext���ֶ����ݻᱻ��������һ���ļ��У�ֻҪ�޸�����ļ����Զ��������ˡ�
    - bean,listͨ���ֺ�;���зָ�������a;b;c��ת�����ͬcsv��׼�������������һ���ַ�������;����ô����"�Ű�������������������������ţ���Ҫ��˫����
        - "a";b;c   ��ͬ��a;b;c
        - "a;b";c   �򱻷�Ϊ2��a;b ��c
        - "a"";b";c Ҳ��2��a";b��c
    - map, lua��֧��map��keyΪbean��
    - ���type�����bean���Ҳ���һ����Ԫ����Ҫ��csv��ڶ�����������Ϊfield.name@xx��ͬʱ���⿪ʼ�����������в�Ҫ�ϣ�Ҫ��config��Ķ���˳��һ�£�������������field�Ľ����㡣

* field.ref, nullableref, keyref
    - ���ã���Ӧconfig.name��keyrefֻ���map
    - list��map ��������nullableref

* field.listref
    - ���ã���Ӧconfig.name,config.field.name��
    - list��map ��������listref

* field.range
    - ��Ӧmin,max��������ͬʱ���У�����ֵ��ȡֵ���䣬���ַ����ǳ������䡣

* ref.name, keys, ref, keyref, nullable
    - �������ɴ���ʱʹ�ã������field.ref����û��ָ��Ĭ�ϵ���field.name
    - ��keys�ж���ֶ�config�����ã���Ҫ���keys�����õ��⡣����һ��fieldҪ���ö��ref���������������
    - ref, keyref ���õ�config.name
    - nullable�Ƿ��Ϊ�գ�Ĭ����false

* listref.name, keys, ref, refkeys
    - �ο�ref������ListRefXXX ���á�

* range.key, min, max
    - field.range ����һ��д����

* config/bean/field.own
    - ������������ַ����������������ʹ�ã�contains���塣
    - ����һ��config.xml��ͨ����������own�������ownѡ�����ɲ��֣���Ϊ�ͻ����ڴ�Ƚ�ϡȱ

## ����

* ����Щע�����

    ��Ԫ���в���Ļ�Ĭ��Ϊfalse,0,""�����Բ�Ҫ��0��Ϊһ�е�id��
    �����nullableref�벻Ҫ��0���������ա����������ⱨ��

* Ϊʲôʹ��csv��

    ��xml��࣬�ɱ��汾����ϵͳdiff������excel�༭�����Ҫ��excel�߼����ܣ���߻�ʹ��excelԭʼ��ʽ������csv

* Ϊʲô֧��enum��

    ����Ҫһ��knowledge���ͻ��ˣ����������߻���Ҫ�˽��ʱ�򣬷ŵ�csv�

* Ϊʲôenum֧�ֲ������ã����ֿհף�

    ��ʱ�������������Ǻܷ���ģ���������һ����id����������Щ�����������enum�������ã������᷽��Ķࡣ
    ����enum��ʵ���ϣ�java���������enum���þ�̬��Ա�����ȫ��enum������enum��c#������Ϊһ����̬��Ա��
    ö�ٵ����þ���Ҫ�����������ħ����

* keys, ref��ʲô��

    keys��Ӧ��sql������ֵ�primary key��Ĭ�ϲ������ã����ǵ�һ�С�
    ref��Ӧ��foreign key����Ϊ���ǲ�֧�ֶ����unique key��ֻҪ˵��ref��Ӧ���Ǹ�table�����ˡ�
    ref���������ڲ߻�����һ���Լ�⣬Ҳ��ֱ�����ɴ��룬�ó���Աֱ�ӷ���

* ΪʲôҪ֧��nullableref��

    java��c#�����ÿ���Ϊnull��Ӧ���Ǹ���ƴ��󡣼򵥵�˵ԭ���������Ϊnull����������״̬����С��������java����
    Optional�͸о��Ǹ�nullableref�ĺ��塣idea����@Nullable����Ϊ���ֲ������
    ��������Լ��ref���Ǳ��������õģ�nullableref�ǿ�Ϊnull�ģ����ɴ���ʱ��ǰ׺ref��nullableRef���������߼�ʹ��refXx�Ͳ��ü���Ƿ�Ϊnull�ˡ�
    �ο���http://www.infoq.com/presentations/Null-References-The-Billion-Dollar-Mistake-Tony-Hoare

* listref��ʹ�ó�����

    ����һ������task���и�ǰ����������pretaskid��ָ��������������ǰ������������ǰ������
    ����Ҫ֪����ǰ������ɺ�Ὺ����Щ����, ��ʱ����listref="task,pretaskid"��
    �������õ����loot��Ȼ��lootitem�Ǿ�����Ϣ��loot�ﲻ��ָ��������Щlootitemid��������lootitem��ָ��lootid��
    �����ٸ�lootid����listref="lootitem,lootid"��

* keyref��ʹ�ó�����

    ֻ���map������û�õ�������������˵ҪӦ���а����ر�������key��enum����Ӧ��ͦ������

* Ƕ�׽ṹ֧�֣�

    ������һ��csv��ֱ������Ƕ��bean��
    Ҳ����ͨ��ref,nullableref֧���˼�Ƕ�׽ṹ��
    ͨ��list,map����ref��nullableref��keyref��ʹ��֧��������Ƕ�׽ṹ��
    ������ͨ��listref��֧����listǶ�׽ṹ��������������Щ������һ����˵���㡣

* �̳�֧�֣�

    ��֧�֣�����2�з���������
    ���ֻ�ǿͻ����ã�ʹ��csharp��partial���ƣ��Լ�д���ӿ��࣬Ȼ�����̳е�������������implement��
    ����������͵�item�ͻ�����Ҫͳһ����
    ���������Ҫ�ã�javaû��partial�������������������һ��bean����̳е����ö�ʹ�����bean��
    ����Fighter��Ҫ��cfg����������monster��hero��

* �ͻ��˸��²��ԣ�

    �ְ�����ʹ�� -gen pack ���pack.xml�����ɷְ��ļ���pack.xml��������Щ�ļ����һ������ʹ��CSVLoader.LoadPack�����ء�
    �������ְ���ֻҪpack.xml�����ھ����ˣ�ȫ��all.zip�

* ���ʻ����ԣ�

    ������Ҫ���ʻ����ֶΣ�����Ϊtext���ͣ�����ʱ�ᵥ���ŵ�text.csv�ֻҪ��������ļ���ok�ˡ�
    �ְ��Ļ����������ʹ�� -packtext text.csv �����text.zip��

* Ϊʲôjava����û����public final��

    ��ȷ��public final int a; �����Ͳ���дgetter�ˣ���಻�١�
    ��ref���ú�����enum��Ҳ���ú�����̫��ͳһ�ˡ�

* ��set��֧���أ�

    ��֧�֣��������ò���̫�࣬ʹ��listЧ�ʹ��ˡ�������ڵ��뷨�ǲ�֧�֡�

* ����

    C#�汾���˸�KeyedList���ڶ�Ӧjava��LinkedHashMap��������˵��Generic��������������Ӧ��ֻ����һ�ݴ��룬��˵����ռ�úܶ����Σ�
    ����֪��Mono�Ƿ�������
