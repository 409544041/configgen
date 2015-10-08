# configgen

�����������ɣ�������Ϊ�Ǹ�������ֻ��object��object-relational mapping��

## ��Ŀ�ſ�

* ͨ�����������ȡֵ��Χ��ʹ�߻�������ʱ�����������
* ͨ�����ɴ��룬ʹ����Ա��������������ͻ�������ݣ�ֱ�ӷ���������úͷ��ʵ���һ�С�
* Ŀǰ֧��java,csharp��������ɣ�������֧��lua

## �������Ŀ��

* �Զ����ɳ����࣬�����ࡣ����ǻ���Ŀ�ꡣ
* �����ļ���ÿ����Ԫ�����ݶ������ͣ�schema����Ϊconfig.xml�������Զ����ɡ������ֹ�������������
* config������keys��Ĭ���ǵ�һ����Ӣ���ֶ�˵�����С�Ҫ���õĻ�������С��������primary key�ˡ�
* config������enum�����ɴ�������������ã���������Զ�resolve������������ÿ�м�¼��
* field��type,һ�㲻�øģ�type��Ϊlist��map���Զ���bean��
* field������ref��nullableref, keyref��listref����������Զ�resolve���á�
* ref�����ö�keys���ã���Ϊһ��field���ö�����á��������foreign key��
* bean���Զ��壬��Ƕ�ף���֧�ֵ���csv�ļ���Ƕ������bean
* ���������ݺʹ���ʱֱ�Ӽ������type��ref��range��Χ��⣬��Ӧprimary key, foreign key ��дconstraint�ļ��
* ������own������ѡ�����ɲ��֣���Ϊ�ͻ����ڴ�Ƚ�ϡȱ������������С����Դ���������ڴ�ռ�á��������Է������ͻ��˹���һ��config.xml

## ʹ������

1. �����½����޸� csv�ļ���csv�ļ�ǰ2��Ϊheader����һ��������˵�����ڶ�����Ӣ���ֶ����ɴ���ʹ��
2. ʹ��configgen.jar �����ɻ����Ʒ������ͻ��˹�ͬʹ�õ�config.xml��������java��csharp, configdata.zip, csv.byte, csv.string
3. ���Ĭ�ϵ���Ϊ����������������ֶ��޸�config.xml�������´γ����Զ�����config.xmlʱ�����е�field������������ã�
4. �ظ�1��2��3����

## ע������

* ��Ԫ���в���Ļ�Ĭ��Ϊfalse,0,""�����Բ�Ҫ��0��Ϊһ�е�id��
* �����nullableref�벻Ҫ��0���������ա����������ⱨ��

## ��������

* config/bean.name
    - �ļ�·����ȫСд��·����.�ָ������package����ͳһ��ͬʱ����linux��windows����
    - bean�����Լ��ֹ���config.xml�ﶨ�壻field.type����bean��ʱ��Ҳ�����ֹ�ָ������Щû���Զ��²⡣

* config.keys
    - Ĭ�ϲ������ã��ǵ�һ��field��������������ã����ŷָ����keys="aa,bb"����2��field aa,bbΪkey

* config.enum
    - Ĭ�ϲ������ã����Ҫ������Ϊenum�������ã�����enum="aa"����field aa��Ϊenum����

* bean.compress
    - Ĭ����false��������bean�Ǳ��ŵ���Ԫ���Ҫ����Ϊtrue

* field.desc, name
    - config.jar���csv�ļ���1,2����ȡ��
    - list a1,a2: nameΪaList
    - map a1,b1,a2,b2: nameΪa2bMap
    - ���ɴ���ʱ����csv���������ƵĴ�Сд��
    - ��Ա����Ϊ����ĸСд��name����Ա����Ϊget+����ĸ��д��name
    - �����õ��������Ա����ΪRef+����ĸ��д��name�� ��Ա����Ϊref/nullableRef+����ĸ��д��name

* field.type
    - bool,int,long,float,string(text),
    - <bean.name>
    - list,xx<,count>     List<>, ArrayList<>��count�����ڵ�ʱ�򣬵�Ԫ����list��count���ڵĻ��Ӷ���fieldname1��fieldname2�������ж�ȡ���ݡ�
    - map,xx,yy,count   Map<>, LinkedHashMap<>; ;xx,yy��Ϊ������ʽ���Ӷ���fieldkey1��fieldvalue1��fieldkey2, fieldvalue2�������ж�ȡ���ݡ�

    - csvһ����Ԫ��,�����ǻ�������,����<bean>,����list�������list��Ԫ�ر����ǻ������ͣ������<bean>���붨��compress="true"
    - <bean>,listͨ���ֺ�;���зָ�������a;b;c��ת�����ͬcsv��׼�������������һ���ַ�������;����ô����"�Ű�������������������������ţ���Ҫ��˫����
        - "a";b;c   ��ͬ��a;b;c
        - "a;b";c   �򱻷�Ϊ2��a;b ��c
        - "a"";b";c Ҳ��2��a";b��c
    - ���type�����bean���Ҳ���һ����Ԫ����Ҫ��csv��ڶ�����������Ϊ<field.name>@xx��ͬʱ���⿪ʼ�����������в�Ҫ�ϣ�Ҫ��config��Ķ���˳��һ�£�������������field�Ľ����㡣

* field.ref, nullableref, keyref
    - ���ã���Ӧ<config.name>��keyrefֻ���map
    - list��map ��������nullableref

* field.listref
    - ���ã���Ӧ<config.name>,<config.field.name>��
    - list��map ��������listref

* field.range
    - ��Ӧ<min>,<max>��������ͬʱ���У�long��ֵ������ֵ��ȡֵ���䣬���ַ����ǳ������䣬ע������û��֧��keyrange��

* ref.name
    - �������ɴ���ʱʹ�ã������field.ref����û��ָ��Ĭ�ϵ���field.name

* ref.keys
    - ��keys�ж���ֶ�config�����ã���Ҫ���keys�����õ��⡣����һ��fieldҪ���ö��ref���������������

* ref.ref, keyref
    - ���õ�config��name

* ref.nullable
    - �Ƿ��Ϊ�գ�Ĭ����false

* listref.name, keys, ref, refkeys
    - �ο�ref������ListRef<name> ���á�

* range.key, min, max
    - ����ֵ��ȡֵ��Χ�����ַ����ǳ��ȷ�Χ

* config/bean/field.own
    ������������ַ����������������ʹ�ã�contains���塣


## ����

* enumҪ��Ҫ���������ã����ֿհף�
>   ��ʱ�������������Ǻܷ���ģ���������һ����id����������Щ�����������enum�������ã������᷽��Ķࡣ
    ����enum��ʵ���ϣ�java���������enum���þ�̬��Ա�����ȫ��enum������enum��c#������Ϊһ����̬��Ա��
    ö�ٵ����þ���Ҫ�����������ħ����

* ΪʲôҪ֧��nullableref��
>   java��c#�����ÿ���Ϊnull��Ӧ���Ǹ���ƴ��󡣼򵥵�˵ԭ���������Ϊnull����������״̬����С��������java����
    Optional<T>�͸о��Ǹ�nullableref�ĺ��塣idea����@Nullable����Ϊ���ֲ������
    ��������Լ��ref���Ǳ��������õģ������ü���ʱ������⣩nullableref�ǿ�Ϊnull�ģ��߼�ʹ��ʱ��⡣
    �ο���http://www.infoq.com/presentations/Null-References-The-Billion-Dollar-Mistake-Tony-Hoare

* Ƕ�׽ṹ֧�֣�
>   ������һ��csv��ֱ������Ƕ��bean
    Ҳ����ͨ��ref,nullableref֧���˼�Ƕ�׽ṹ��
    ͨ��list,map����ref��nullableref��keyref��ʹ��֧��������Ƕ�׽ṹ��
    ������ͨ��listref��֧����listǶ�׽ṹ��������������Щ������һ����˵���㡣

* listref��ʹ�ó�����
>   ����һ������task���и�ǰ����������pretaskid��
    ָ��������������ǰ������������ǰ����������Ҫ֪����ǰ������ɺ�Ὺ����Щ����
    ��ʱ����<field name=��id��, listref="task,pretaskid��/>�Զ�����List<Task> ListrefId��
    �������õ����loot��Ȼ��lootitem�Ǿ�����Ϣ��loot�ﲻ��ָ��������Щlootitemid��������lootitem��ָ��lootid��
    �����ٸ�lootid����listref="lootitem,lootid"��


* keyref��ʹ�ó�����
>   ֻ���map������û�õ�������������˵ҪӦ���а����ر�������key��enum����Ӧ��ͦ������

* ��set��֧���أ�
>   ��֧�֣��������ò���̫�࣬ʹ��listЧ�ʹ��ˡ�������ڵ��뷨�ǲ�֧�֡�

* ����
>   C#�汾���˸�KeyedList���ڶ�Ӧjava��LinkedHashMap��������˵��Generic��������������Ӧ��ֻ����һ�ݴ��룬��˵����ռ�úܶ����Σ�
    ����֪��Mono�Ƿ�������
    C#�汾��������ļ����ܣ�������Ǹ��£��ǲ���Ӧ�÷ֿ��ļ����£�

* һЩ��������