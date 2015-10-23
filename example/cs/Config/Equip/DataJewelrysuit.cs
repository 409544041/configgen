using System;
using System.Collections.Generic;
using System.IO;

namespace Config.Equip
{
    public partial class DataJewelrysuit
    {
        public int SuitID { get; private set; } // ��Ʒ��װID
        public string Name { get; private set; } // �߻�������
        public int Ability1 { get; private set; } // ��װ��������1��װ����װ�е�����ʱ���ӵ����ԣ�
        public int Ability1Value { get; private set; } // ��װ����1
        public int Ability2 { get; private set; } // ��װ��������2��װ����װ�е�����ʱ���ӵ����ԣ�
        public int Ability2Value { get; private set; } // ��װ����2
        public int Ability3 { get; private set; } // ��װ��������3��װ����װ�е��ļ�ʱ���ӵ����ԣ�
        public int Ability3Value { get; private set; } // ��װ����3
        public List<int> SuitList { get; private set; } // ����1

        public override int GetHashCode()
        {
            return SuitID.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if (obj == null) return false;
            if (obj == this) return true;
            var o = obj as DataJewelrysuit;
            return o != null && SuitID.Equals(o.SuitID);
        }

        public override string ToString()
        {
            return "(" + SuitID + "," + Name + "," + Ability1 + "," + Ability1Value + "," + Ability2 + "," + Ability2Value + "," + Ability3 + "," + Ability3Value + "," + CSV.ToString(SuitList) + ")";
        }

        static Config.KeyedList<int, DataJewelrysuit> all = null;

        public static List<DataJewelrysuit> All()
        {
            return all.OrderedValues;
        }

        public static DataJewelrysuit Get(int suitID)
        {
            DataJewelrysuit v;
            return all.TryGetValue(suitID, out v) ? v : null;
        }

        public static List<DataJewelrysuit> Filter(Predicate<DataJewelrysuit> predicate)
        {
            var r = new List<DataJewelrysuit>();
            foreach (var e in all.OrderedValues)
            {
                if (predicate(e))
                    r.Add(e);
            }
            return r;
        }

        internal static void Initialize(Config.Stream os, Config.LoadErrors errors)
        {
            all = new Config.KeyedList<int, DataJewelrysuit>();
            for (var i = 0; i < os.ReadSize(); i++) {
                var self = _create(os);
                all.Add(self.SuitID, self);
            }
        }

        internal static DataJewelrysuit _create(Config.Stream os)
        {
            var self = new DataJewelrysuit();
            self.SuitID = os.ReadInt32();
            self.Name = os.ReadText();
            self.Ability1 = os.ReadInt32();
            self.Ability1Value = os.ReadInt32();
            self.Ability2 = os.ReadInt32();
            self.Ability2Value = os.ReadInt32();
            self.Ability3 = os.ReadInt32();
            self.Ability3Value = os.ReadInt32();
            self.SuitList = new List<int>();
            for (var c = (int)os.ReadSize(); c > 0; c--)
                self.SuitList.Add(os.ReadInt32());
            return self;
        }

    }
}