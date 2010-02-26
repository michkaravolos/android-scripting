######################################################################
# tc_abs.rb
#
# Test case for the Fixnum#abs instance method.
######################################################################
require 'test/unit'

class TC_Fixnum_Abs_InstanceMethod < Test::Unit::TestCase
   def setup
      @num_zero  = 0
      @num_pos   = 100
      @num_neg   = -100
      @num_twop  = 2147483648
      @num_twon  = -2147483648
      @num_twopb = 9223372036854775808
      @num_twonb = -9223372036854775808
   end

   def test_abs_basic
      assert_respond_to(@num_pos, :abs)
      assert_nothing_raised{ @num_pos.abs }
      assert_kind_of(Fixnum, @num_pos.abs)
   end

   def test_abs_integer
      assert_equal(0, @num_zero.abs)
      assert_equal(100, @num_pos.abs)
      assert_equal(100, @num_neg.abs)
   end

   def test_abs_twos_complement
      assert_equal(2147483648, @num_twop.abs)
      assert_equal(2147483648, @num_twon.abs)
      assert_equal(9223372036854775808, @num_twopb.abs)
      assert_equal(9223372036854775808, @num_twonb.abs)
   end

   def test_abs_expected_errors
      assert_raise(ArgumentError){ @num_pos.abs(1) }
   end
   
   def teardown
      @num_zero  = nil
      @num_pos   = nil
      @num_neg   = nil
      @num_twop  = nil
      @num_twon  = nil
      @num_twopb = nil
      @num_twonb = nil
   end
end
