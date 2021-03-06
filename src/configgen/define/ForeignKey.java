package configgen.define;

import configgen.Node;
import org.w3c.dom.Element;

public class ForeignKey extends Node {
    public enum RefType {
        NORMAL,
        NULLABLE,
        LIST
    }

    public final String[] keys;
    public Ref ref;
    public RefType refType;
    public Ref mapKeyRef;

    public ForeignKey(Bean _parent, Element self) {
        super(_parent, self.getAttribute("name"));
        DomUtils.permitAttributes(self, "name", "keys", "ref", "refType", "keyRef");
        keys = DomUtils.parseStringArray(self, "keys");
        init(self);
    }

    public ForeignKey(Column _parent, Element self) {
        super(_parent, self.getAttribute("name"));
        keys = new String[]{name};
        init(self);
    }

    private void init(Element self) {
        ref = new Ref(self.getAttribute("ref"));
        if (self.hasAttribute("refType")) {
            refType = RefType.valueOf(self.getAttribute("refType").toUpperCase());
        } else {
            refType = RefType.NORMAL;
        }
        String keyref = self.getAttribute("keyRef");
        if (keyref.isEmpty()) {
            mapKeyRef = null;
        } else {
            mapKeyRef = new Ref(keyref);
        }
    }

    ForeignKey(Node _parent, ForeignKey original) {
        super(_parent, original.name);
        keys = original.keys;
        ref = original.ref;
        refType = original.refType;
        mapKeyRef = original.mapKeyRef;
    }

    void checkInclude(ForeignKey stable) {
        require(stable.ref.equal(ref) && refType == stable.refType, "foreignKey check include err");
        if (stable.mapKeyRef != null){
            require(stable.mapKeyRef.equal(mapKeyRef), "foreignKey check mapKeyRef include err" );
        }
    }

    boolean invalid() {
        Db db = (Db) root;
        return !(ref.valid(db) && (mapKeyRef == null || mapKeyRef.valid(db)));
    }

    void save(Element parent) {
        Element self = DomUtils.newChild(parent, "foreignKey");
        self.setAttribute("name", name);
        self.setAttribute("keys", String.join(",", keys));
        update(self);
    }

    void update(Element self) {
        self.setAttribute("ref", ref.toString());
        if (refType != RefType.NORMAL)
            self.setAttribute("refType", refType.toString());
        if (mapKeyRef != null)
            self.setAttribute("keyRef", mapKeyRef.toString());
    }
}
